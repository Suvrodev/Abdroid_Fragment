package com.example.inflater_good;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SuvrodevGridAdapter extends RecyclerView.Adapter<SuvrodevGridAdapter.MyViewHolder> {

    Context context;
    String[] CountryNames;
    int[] Flags;

    public SuvrodevGridAdapter(Context context, String[] countryNames, int[] flags) {
        this.context = context;
        CountryNames = countryNames;
        Flags = flags;
    }

    @NonNull
    @Override
    public SuvrodevGridAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.grid_sample,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuvrodevGridAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(Flags[position]);
        holder.title.setText(CountryNames[position]);
    }

    @Override
    public int getItemCount() {
        return CountryNames.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.id_gridview_image);
            title=itemView.findViewById(R.id.id_gridview_text);
        }
    }
}
