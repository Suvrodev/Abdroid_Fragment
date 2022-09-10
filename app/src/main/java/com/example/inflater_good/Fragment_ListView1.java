package com.example.inflater_good;

import android.icu.text.Transliterator;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class Fragment_ListView1 extends Fragment{

    TabLayout tabLayout;
    ViewPager viewPager;
    int Global_Position=0;

    ///Used for backpressed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback=new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(Global_Position>0){
                    viewPager.setCurrentItem(0);
                }else {
                    getActivity().finish();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this,callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_listview1, container, false);

        tabLayout=view.findViewById(R.id.id_tablayout_1);
        viewPager=view.findViewById(R.id.id_viewPager_1);


        viewPager.setAdapter(new MyPAgeAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Global_Position=tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(Global_Position);
                Global_Position=tab.getPosition();
            }
        });




        return view;
    }



    class MyPAgeAdapter extends FragmentPagerAdapter {

        String[] Text={"List View","Recycler view"};

        public MyPAgeAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return new Fragment_ListView1_ListView();
            }else if(position==1){
                return new Fragment_ListView1_RecyclerView();
            }
            return null;  //2nd Time press korle udhao hoye jay kano?  //getChildFragmentManager not getparent

        }

        @Override
        public int getCount() {
            return Text.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return Text[position];
        }
    }



}