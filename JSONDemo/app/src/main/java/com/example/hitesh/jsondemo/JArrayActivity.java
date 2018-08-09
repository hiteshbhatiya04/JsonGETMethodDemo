package com.example.hitesh.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import com.example.hitesh.jsondemo.Adapters.JArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class JArrayActivity extends AppCompatActivity {

    String json = "{\"employees\":[    \n" +
            "    {\"name\":\"Ram\", \"email\":\"ram@gmail.com\", \"age\":23},    \n" +
            "    {\"name\":\"Shyam\", \"email\":\"shyam23@gmail.com\", \"age\":28},  \n" +
            "    {\"name\":\"John\", \"email\":\"john@gmail.com\", \"age\":33},    \n" +
            "    {\"name\":\"Bob\", \"email\":\"bob32@gmail.com\", \"age\":41}   \n" +
            "]} ";
    ListView listView;
    ArrayList<HashMap<String,String>> hashMapArrayList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.j_array);

        listView = (ListView)findViewById(R.id.emp_list);

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("employees");
            for (int j =0;j<jsonArray.length();j++)
            {
                JSONObject jsonObject1 = jsonArray.getJSONObject(j);
                String name = jsonObject1.getString("name");
                String mail = jsonObject1.getString("email");
                int age = jsonObject1.getInt("age");

                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("nam",name);
                hashMap.put("emai",mail);
                hashMap.put("ag",String.valueOf(age));
                hashMapArrayList.add(hashMap);


            }
            JArrayAdapter adapter = new JArrayAdapter(JArrayActivity.this,R.layout.jason_array_adapter,hashMapArrayList);
            listView.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
