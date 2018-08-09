package com.example.hitesh.jsondemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.hitesh.jsondemo.Adapters.ActorAdapter;
import com.example.hitesh.jsondemo.Adapters.RecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ActorDetail extends AppCompatActivity {

    String Actor_URL = "http://microblogging.wingnity.com/JSONParsingTutorial/jsonActors";

    ListView listView;
    ArrayList<HashMap<String,String>>hashMapArrayList =new ArrayList<>();
    RecyclerView recyclerView;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_detail);

        listView = (ListView)findViewById(R.id.actor_list);
        //recyclerView = (RecyclerView)findViewById(R.id.actor_recycle);
        new ActorData().execute();

}

    private class ActorData extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(ActorDetail.this);
            dialog.setMessage("Connecting");
            dialog.setTitle("Loading");
            dialog.show();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            ActorDataParser dataParser = new ActorDataParser();
            String result = dataParser.getJson(Actor_URL);

            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray =jsonObject.getJSONArray("actors");

                for (int i =0;i<jsonArray.length();i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String name = jsonObject1.getString("name");
                    String disc = jsonObject1.getString("description");
                    String dob = jsonObject1.getString("dob");
                    String country = jsonObject1.getString("country");
                    String height = jsonObject1.getString("height");
                    String spouse = jsonObject1.getString("spouse");
                    String children = jsonObject1.getString("children");
                    String image = jsonObject1.getString("image");


                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("name",name);
                    hashMap.put("description",disc);
                    hashMap.put("dob",dob);
                    hashMap.put("country",country);
                    hashMap.put("height",height);
                    hashMap.put("spouse",spouse);
                    hashMap.put("children",children);
                    hashMap.put("image",image);

                    hashMapArrayList.add(hashMap);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            dialog.dismiss();
            ActorAdapter adapter = new ActorAdapter(ActorDetail.this,R.layout.actor_layout,hashMapArrayList);
            listView.setAdapter(adapter);
            super.onPostExecute(aVoid);
        }
    }
}
