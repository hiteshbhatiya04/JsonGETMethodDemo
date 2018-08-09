package com.example.hitesh.jsondemo.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hitesh.jsondemo.ActorDetail;
import com.example.hitesh.jsondemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context context;
    ArrayList<HashMap<String, String>> hashMapArrayList;

    public RecyclerAdapter(ActorDetail actorDetail, ArrayList<HashMap<String, String>> hashMapArrayList) {
        this.context = actorDetail;
        this.hashMapArrayList =hashMapArrayList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.re_actor_adapter,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {

        holder.name.setText(hashMapArrayList.get(position).get("name"));
        holder.disc.setText(hashMapArrayList.get(position).get("description"));
        holder.dob.setText("DOB : "+hashMapArrayList.get(position).get("dob"));
        holder.height.setText("Height : "+hashMapArrayList.get(position).get("height"));
        holder.country.setText("Country : "+hashMapArrayList.get(position).get("country"));
        holder.child.setText("Children : "+hashMapArrayList.get(position).get("children"));
        holder.spouse.setText("Spouse : "+hashMapArrayList.get(position).get("spouse"));
        Picasso.with(context)
                .load(hashMapArrayList.get(position).get("image"))
                .error(R.drawable.ic_launcher_background)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return hashMapArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,disc,dob,height,child,spouse,country;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.ract_name);
            disc = (TextView)itemView.findViewById(R.id.ract_disc);
            dob = (TextView)itemView.findViewById(R.id.ract_dob);
            height = (TextView)itemView.findViewById(R.id.ract_height);
            child = (TextView)itemView.findViewById(R.id.ract_child);
            spouse = (TextView)itemView.findViewById(R.id.ract_spouse);
            country = (TextView)itemView.findViewById(R.id.ract_country);
            imageView = (ImageView)itemView.findViewById(R.id.ract_img);
        }
    }
}
