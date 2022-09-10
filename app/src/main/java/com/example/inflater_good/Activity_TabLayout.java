package com.example.inflater_good;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class Activity_TabLayout extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        tabLayout= (TabLayout) findViewById(R.id.id_tablayout);
        viewPager= (ViewPager) findViewById(R.id.id_viewPager);

        viewPager.setAdapter(new MyPAgeAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                //Global_Position=tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ///Bundle
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            String Value=bundle.getString("k1");
            Toast.makeText(getApplicationContext(),Value,Toast.LENGTH_SHORT).show();
            if(Value.equalsIgnoreCase("2")){
               viewPager.setCurrentItem(1);
            }
            if(Value.equalsIgnoreCase("3")){
                viewPager.setCurrentItem(2);
            }

            if(Value.equalsIgnoreCase("4")){
                viewPager.setCurrentItem(1);
            }
        }
    }

    class MyPAgeAdapter extends FragmentPagerAdapter {

        String[] Text={"Base Adapter","Recycler view","Grid View"};

        public MyPAgeAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position==0){
                return new Fragment_BaseAdapter();
            }else if(position==1){
                return new Fragment_Recycler();
            }else if(position==2){
                return new Fragment_Gridview();
            }
            return null;
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