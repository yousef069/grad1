package com.example.yousefgrad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class adapter extends  RecyclerView.Adapter<adapter.ContactHolder> {
    private List<driver> dinfo =new ArrayList<>();
Context context;
    track trackdriverlistener;

    public void setResult(List<driver> dinfo) {
        this.dinfo = dinfo;
        notifyDataSetChanged();
    }
    public adapter(Context context,track tracklistner) {
        this.context = context;
        this.trackdriverlistener = tracklistner;
        notifyDataSetChanged();


    }
    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new ContactHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        driver m=  dinfo.get(position);
        if(dinfo.get(position).getStatus().equals("online")) {

            holder.driveremail.setText(dinfo.get(position).getUsername());
            holder.drivermobile.setText(dinfo.get(position).getMobile());
        }
        else
        {
            holder.driveremail.setText("Unavaialble Now");
            holder.drivermobile.setText("Unavaialble Now");
        }
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(m.getLocation1()!=null)
        {
            trackdriverlistener.track(m);
        }

    }
});

    }

    @Override
    public int getItemCount() {
        return dinfo.size();
    }
    static class ContactHolder extends RecyclerView.ViewHolder{
        TextView driveremail,drivermobile;

        public ContactHolder(@NonNull View itemView) {
            super(itemView);
            driveremail=itemView.findViewById(R.id.driverinfo);
            drivermobile=itemView.findViewById(R.id.drivermobile);

        }
    }

}
