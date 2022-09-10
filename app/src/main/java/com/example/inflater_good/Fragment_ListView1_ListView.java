package com.example.inflater_good;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Fragment_ListView1_ListView extends Fragment {

    ListView listView;
    String[] CountryNames;
    ArrayAdapter<String> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment__listview1_listview, container, false);

        CountryNames=getResources().getStringArray(R.array.CountryNames);
        listView=view.findViewById(R.id.id_listview_1);

        adapter=new ArrayAdapter<String>(getContext(),R.layout.suvrodeb_list_sample_recycler,R.id.id_ok_title,CountryNames);
        listView.setAdapter(adapter);

        return view;
    }
}