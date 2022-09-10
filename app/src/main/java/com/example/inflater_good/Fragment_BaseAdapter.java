package com.example.inflater_good;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class Fragment_BaseAdapter extends Fragment {


    ListView listView;
    String[] Country_Names;
    String[] Desc;
    CustomApater customApater;
    int[] Flags={
            R.drawable.bangladesh_flag, R.drawable.india_flag, R.drawable.sri_lanka_flag, R.drawable.pakistan_flag, R.drawable.nepal_flag,
            R.drawable.bhutan_flag, R.drawable.australia_flag, R.drawable.nz_flag, R.drawable.finland_flag, R.drawable.ireland_flag,
            R.drawable.usa_flag, R.drawable.uk_flag, R.drawable.canada_flag, R.drawable.german_flag, R.drawable.south_africa_flag, R.drawable.brazil_flag,
            R.drawable.argentina_flag, R.drawable.china_flagg, R.drawable.greenland_flag,R.drawable.japan_flag
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment__base_adapter, container, false);

        Country_Names=getResources().getStringArray(R.array.CountryNames);
        Desc=getResources().getStringArray(R.array.desc);
        listView=view.findViewById(R.id.id_listview_base);

        customApater=new CustomApater(getContext(),Flags,Country_Names,Desc);
        listView.setAdapter(customApater);

        return view;
    }
}