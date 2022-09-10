package com.example.inflater_good;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Option extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        btn_1= (Button) findViewById(R.id.id_list);
        btn_2= (Button) findViewById(R.id.id_image_);
        btn_3= (Button) findViewById(R.id.id_task_);
        btn_4= (Button) findViewById(R.id.id_tl1);
        btn_5= (Button) findViewById(R.id.id_tl2);
        btn_6= (Button) findViewById(R.id.id_tl3);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_Option.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_Option.this,MainActivity.class);
                intent.putExtra("k1","2");
                startActivity(intent);

            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_Option.this,MainActivity.class);
                intent.putExtra("k1","3");
                startActivity(intent);

            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_Option.this,Activity_TabLayout.class);
                startActivity(intent);
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_Option.this,Activity_TabLayout.class);
                intent.putExtra("k1","2");
                startActivity(intent);
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_Option.this,Activity_TabLayout.class);
                intent.putExtra("k1","3");
                startActivity(intent);
            }
        });


    }
}