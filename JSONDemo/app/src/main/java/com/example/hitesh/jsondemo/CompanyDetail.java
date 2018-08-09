package com.example.hitesh.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CompanyDetail extends AppCompatActivity {

    String json = "{\n" +
            "  \n" +
            "  \"array\":[\n" +
            "    {\n" +
            "    \"company\":\"Google\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"company\":\"Facebook\"\n" +
            "    },\n" +
            "    {\n" +
            "    \"company\":\"LinkedIn\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"company\" : \"Microsoft\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"company\": \"Apple\"\n" +
            "    }\n" +
            "    ]\n" +
            "  \n" +
            "}";
    ListView listView;
    ArrayList<String>stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail);

        listView = (ListView)findViewById(R.id.cmpny_list);
        stringList = new ArrayList<>();


        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("array");
            for (int i = 0 ; i<jsonArray.length();i++)
            {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String cmpny = jsonObject1.getString("company");
                stringList.add(cmpny);
                ArrayAdapter<String>arrayAdapter =new ArrayAdapter<String>(CompanyDetail.this,android.R.layout.simple_list_item_1,stringList);
                listView.setAdapter(arrayAdapter);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
