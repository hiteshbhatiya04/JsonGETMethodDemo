package com.example.hitesh.jsondemo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hitesh.jsondemo.JArrayActivity;
import com.example.hitesh.jsondemo.R;

import java.util.ArrayList;
import java.util.HashMap;

public class JArrayAdapter extends BaseAdapter {
    Context context;
    ArrayList<HashMap<String, String>> hashMapArrayList;
    int jason_array_adapter;

    public JArrayAdapter(JArrayActivity jArray, int jason_array_adapter, ArrayList<HashMap<String, String>> hashMapArrayList) {

        this.context = jArray;
        this.hashMapArrayList = hashMapArrayList;
        this.jason_array_adapter = jason_array_adapter;
    }

    @Override
    public int getCount() {
        return hashMapArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View view1 = LayoutInflater.from(context).inflate(jason_array_adapter,null);
        TextView name = (TextView)view1.findViewById(R.id.txt_aname);
        TextView email = (TextView)view1.findViewById(R.id.txt_email);
        TextView age = (TextView)view1.findViewById(R.id.txt_age);

        name.setText(hashMapArrayList.get(i).get("nam"));
        email.setText(hashMapArrayList.get(i).get("emai"));
        age.setText(hashMapArrayList.get(i).get("ag"));


        return view1;
    }
}
