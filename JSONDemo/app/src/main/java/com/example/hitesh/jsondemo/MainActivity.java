package com.example.hitesh.jsondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button single,array,country,compny,actor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        single =(Button)findViewById(R.id.btn_single);
        array =(Button)findViewById(R.id.btn_array);
        country =(Button)findViewById(R.id.btn_country);
        compny =(Button)findViewById(R.id.btn_cmpny);
        actor =(Button)findViewById(R.id.btn_actor);

        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,SingleObject.class);
                startActivity(intent);
            }
        });
        array.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,JArrayActivity.class);
                startActivity(intent);
            }
        });

        country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,CountryDetail.class);
                startActivity(intent);
            }
        });
        compny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,CompanyDetail.class);
                startActivity(intent);
            }
        });

        actor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,ActorDetail.class);
                startActivity(intent);
            }
        });


    }
}
