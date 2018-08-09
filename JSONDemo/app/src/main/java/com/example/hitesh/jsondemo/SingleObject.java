package com.example.hitesh.jsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class SingleObject extends AppCompatActivity {


    TextView tname,tsalary,tmrg;

    String json = "{  \n" +
            "    \"employee\": {  \n" +
            "        \"name\":       \"sonoo\",   \n" +
            "        \"salary\":      56000,   \n" +
            "        \"married\":    false  \n" +
            "    }  \n" +
            "} ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_object);

        tname = (TextView) findViewById(R.id.txt_name);
        tsalary = (TextView) findViewById(R.id.txt_salary);
        tmrg = (TextView) findViewById(R.id.txt_mrg);

        try {
            JSONObject object = new JSONObject(json);
            JSONObject object1 = object.getJSONObject("employee");
            String name = object1.getString("name");
            int salary = object1.getInt("salary");
            Boolean married = object1.getBoolean("married");

            tname.setText(name);
            tsalary.setText(String.valueOf(salary));
            if (married == true){
                tmrg.setText("Married");
            }
            else tmrg.setText("Unmarried");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
