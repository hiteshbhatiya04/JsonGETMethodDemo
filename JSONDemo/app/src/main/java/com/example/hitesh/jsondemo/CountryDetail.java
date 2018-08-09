package com.example.hitesh.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class CountryDetail extends AppCompatActivity {

    TextView tcountry,tsunrise,tsunset,tid,tmain,tdisc,ticon,ttemp,tpres;

    String jsonnn ="{\n" +
            "   \"sys\":\n" +
            "   {\n" +
            "      \"country\":\"GB\",\n" +
            "      \"sunrise\":1381107633,\n" +
            "      \"sunset\":1381149604\n" +
            "   },\n" +
            "   \"weather\":[\n" +
            "      {\n" +
            "         \"id\":711,\n" +
            "         \"main\":\"Smoke\",\n" +
            "         \"description\":\"smoke\",\n" +
            "         \"icon\":\"50n\"\n" +
            "      }\n" +
            "   ],\n" +
            "\t\n" +
            "  \"main\":\n" +
            "   {\n" +
            "      \"temp\":304.15,\n" +
            "      \"pressure\":1009\n" +
            "   }\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        tcountry = (TextView)findViewById(R.id.txt_cou);
        tsunrise = (TextView)findViewById(R.id.txt_sr);
        tsunset = (TextView)findViewById(R.id.txt_ss);
        tid = (TextView)findViewById(R.id.txt_id);
        tmain = (TextView)findViewById(R.id.txt_main);
        tdisc = (TextView)findViewById(R.id.txt_discr);
        ticon = (TextView)findViewById(R.id.txt_icon);
        ttemp = (TextView)findViewById(R.id.txt_temp);
        tpres = (TextView)findViewById(R.id.txt_prs);

        try {
            JSONObject object = new JSONObject(jsonnn);
            JSONObject object1 = object.getJSONObject("sys");
            String country  = object1.getString("country");
            int sunrise = object1.getInt("sunrise");
            int sunset = object1.getInt("sunset");
            JSONArray jsonArray = object.getJSONArray("weather");
            for (int i = 0; i<jsonArray.length();i++)
            {
                JSONObject object2 = jsonArray.getJSONObject(i);
                int id = object2.getInt("id");
                String main = object2.getString("main");
                String discr = object2.getString("description");
                String icon = object2.getString("icon");

                tid.setText(String.valueOf(id));
                tmain.setText(main);
                tdisc.setText(discr);
                ticon.setText(icon);

            }
            JSONObject object3=object.getJSONObject("main");
            int temp = object3.getInt("temp");
            int pressure = object3.getInt("pressure");

            tcountry.setText(country);
            tsunrise.setText(String.valueOf(sunrise));
            tsunset.setText(String.valueOf(sunset));
            ttemp.setText(String.valueOf(temp));
            tpres.setText(String.valueOf(pressure));




        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
