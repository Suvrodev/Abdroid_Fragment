package com.example.inflater_good;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SuvrodevAdapter extends RecyclerView.Adapter<SuvrodevAdapter.MyViewHolder> {

    Context context;
    String[] CountryNames;

    public SuvrodevAdapter(Context context, String[] countryNames) {
        this.context = context;
        CountryNames = countryNames;
    }

    @NonNull
    @Override
    public SuvrodevAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.suvrodeb_list_sample_recycler,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuvrodevAdapter.MyViewHolder holder, int position) {
        holder.Title.setText(CountryNames[position]);
    }

    @Override
    public int getItemCount() {
        return CountryNames.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Title=itemView.findViewById(R.id.id_ok_title);
        }
    }
}
