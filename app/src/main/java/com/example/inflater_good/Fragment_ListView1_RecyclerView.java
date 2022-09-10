package com.example.inflater_good;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment_ListView1_RecyclerView extends Fragment {


    RecyclerView recyclerView;
    String[] CountryNames;

    SuvrodevAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment__listview1_recyclerview, container, false);
        CountryNames=getResources().getStringArray(R.array.CountryNames);


        recyclerView=view.findViewById(R.id.id_recycler_without_pic);
        adapter=new SuvrodevAdapter(getContext(),CountryNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}