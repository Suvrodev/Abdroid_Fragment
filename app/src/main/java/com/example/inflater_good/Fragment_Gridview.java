package com.example.inflater_good;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;


public class Fragment_Gridview extends Fragment {

    GridView gridView;
    GridAdapter adapter;
    SuvrodevGridAdapter adapter_;
    String[] CoutryNames;
    int[] Flags={
            R.drawable.bangladesh_flag, R.drawable.india_flag, R.drawable.sri_lanka_flag, R.drawable.pakistan_flag, R.drawable.nepal_flag,
            R.drawable.bhutan_flag, R.drawable.australia_flag, R.drawable.nz_flag, R.drawable.finland_flag, R.drawable.ireland_flag,
            R.drawable.usa_flag, R.drawable.uk_flag, R.drawable.canada_flag, R.drawable.german_flag, R.drawable.south_africa_flag, R.drawable.brazil_flag,
            R.drawable.argentina_flag, R.drawable.china_flagg, R.drawable.greenland_flag,R.drawable.japan_flag
    };

    Button ClickButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment__gridview, container, false);

        gridView= view.findViewById(R.id.id_gridviews);
        CoutryNames=getResources().getStringArray(R.array.CountryNames);

        ClickButton=view.findViewById(R.id.click_id);
        ClickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Clicked",Toast.LENGTH_SHORT).show();
                gridView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });

        adapter = new GridAdapter(getContext(), CoutryNames, Flags);
        gridView.setAdapter(adapter);

        //adapter_=new SuvrodevGridAdapter(getContext(),CoutryNames,Flags);


        return view;
    }
}