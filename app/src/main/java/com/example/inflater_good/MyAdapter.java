package com.example.inflater_good;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    int[] Flags;
    String[] CountryNames;
    String[] Desc;

    public MyAdapter(Context context, int[] flags, String[] countryNames, String[] desc) {
        this.context = context;
        Flags = flags;
        CountryNames = countryNames;
        Desc = desc;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.suvrodeb_sample_recycler,parent,false);

        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.suvrodeb_sample_recycler,parent,false);
        MyViewHolder mh=new MyViewHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(Flags[position]);
        holder.title.setText(CountryNames[position]);
        holder.description.setText(Desc[position]);
    }

    @Override
    public int getItemCount() {
        return CountryNames.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.ok_img);
            title=itemView.findViewById(R.id.ok_title);
            description=itemView.findViewById(R.id.ok_desc);
        }
    }
}
