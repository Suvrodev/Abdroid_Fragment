package com.example.inflater_good;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            frameLayout = (FrameLayout) findViewById(R.id.id_framelayout);
            bottomNavigationView = (BottomNavigationView) findViewById(R.id.id_bottom_nav);

            bottomNavigationView.setOnItemSelectedListener(listener);
            getSupportFragmentManager().beginTransaction().replace(R.id.id_framelayout, new Fragment_ListView1()).commit();


            ///Bundle
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                String Value = bundle.getString("k1");
              //  Toast.makeText(getApplicationContext(), Value, Toast.LENGTH_SHORT).show();
                if (Value.equalsIgnoreCase("2")) {
                    bottomNavigationView.setSelectedItemId(R.id.id_bn_lrg_image);
                }
                if (Value.equalsIgnoreCase("3")) {
                    bottomNavigationView.setSelectedItemId(R.id.id_bn_task);
                }
                if (Value.equalsIgnoreCase("10")) {
                    bottomNavigationView.setSelectedItemId(R.id.id_bn_lrg_image);
                }
            }
        }catch (Exception e){
            //Toast.makeText(getApplicationContext(),"Problem: "+e.toString(),Toast.LENGTH_SHORT).show();
        }

    }

   public BottomNavigationView.OnNavigationItemSelectedListener listener=new BottomNavigationView.OnNavigationItemSelectedListener() {
       @Override
       public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           Fragment Selected_Fragment=null;
           switch (item.getItemId()){
               case R.id.id_bn_listview:
                   Selected_Fragment=new Fragment_ListView1();
                   break;
               case R.id.id_bn_lrg_image:
                   Selected_Fragment=new Fragment_Image();
                   break;
               case R.id.id_bn_task:
                   Selected_Fragment=new Fragment_Task();
                   break;
//               default:
//                   Selected_Fragment=new Fragment_ListView1();
//                   break;
           }
           getSupportFragmentManager().beginTransaction().replace(R.id.id_framelayout,Selected_Fragment).commit();
           return true;
       }
   };

    @Override
    public void onBackPressed() {
        if(bottomNavigationView.getSelectedItemId()==R.id.id_bn_listview){
            super.onBackPressed();
        }else {
            bottomNavigationView.setSelectedItemId(R.id.id_bn_listview);
        }
    }

    /////Option Menu
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.id_option_home:
                Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.id_option_setting:
                Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.id_option_feedback:
                Toast.makeText(getApplicationContext(),"Feedback",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.id_option_share:
                Toast.makeText(getApplicationContext(),"Share",Toast.LENGTH_SHORT).show();
                BottomSheet();
                return true;
            case R.id.id_option_image:
                bottomNavigationView.setSelectedItemId(R.id.id_bn_lrg_image);
                return true;
            case R.id.id_option_task:
                bottomNavigationView.setSelectedItemId(R.id.id_bn_task);
                return true;
            case R.id.id_option_activity:
                Intent intent=new Intent(this,Activity_Option.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    ///Option Menu end
    private void BottomSheet() {
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity.this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        Button button=bottomSheetDialog.findViewById(R.id.thisisbaal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Ok",Toast.LENGTH_SHORT).show();
            }
        });
        bottomSheetDialog.show();
    }

}