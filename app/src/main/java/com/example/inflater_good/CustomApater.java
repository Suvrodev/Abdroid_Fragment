package com.example.inflater_good;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomApater extends BaseAdapter {

    Context context;
    int[] Flags;
    String[] CountryNames;
    String[] Desc;

    private LayoutInflater inflater;

    public CustomApater(Context context, int[] flags, String[] countryNames, String[] desc) {
        this.context = context;
        Flags = flags;
        CountryNames = countryNames;
        Desc = desc;
    }

    @Override
    public int getCount() {
        return CountryNames.length;
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
        if(view==null){
           inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.suvrodeb_sample_recycler,viewGroup,false);
        }
        ImageView imageView=(ImageView) view.findViewById(R.id.ok_img);
        TextView textView=(TextView) view.findViewById(R.id.ok_title);
        TextView desc= (TextView)view.findViewById(R.id.ok_desc);

        imageView.setImageResource(Flags[i]);
        textView.setText(CountryNames[i]);
        desc.setText(Desc[i]);
        return view;
    }
}
