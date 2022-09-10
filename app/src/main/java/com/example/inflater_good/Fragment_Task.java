package com.example.inflater_good;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;


public class Fragment_Task extends Fragment {


    Button PopupButton;
    Button BottomSheet;
    TextView ContextMenu;
    Button BaseButton,RecyclerinTablayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment__task, container, false);

        BottomSheet=view.findViewById(R.id.id_bottomSheet);
        BaseButton=view.findViewById(R.id.id_rccl);
        RecyclerinTablayout=view.findViewById(R.id.id_meladur);
        BaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),MainActivity.class);
                intent.putExtra("k1","10");
                startActivity(intent);
            }
        });

        RecyclerinTablayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Meladur Jabo",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(),Activity_TabLayout.class);
                intent.putExtra("k1","4");
                startActivity(intent);
            }
        });

        BottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Bottom Sheet",Toast.LENGTH_SHORT).show();
                BottomSheet();
            }
        });



        PopupButton=view.findViewById(R.id.id_popupmenu);
        PopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu=new PopupMenu(getContext(),PopupButton);
                popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(getContext(),"You Clicked: "+menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        ContextMenu=view.findViewById(R.id.id_context_menu);
        registerForContextMenu(ContextMenu);

        return view;
    }

    @Override
    public void onCreateContextMenu( android.view.ContextMenu menu,  View v, android.view.ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select One");
       // menu.add(R.id.id_)

    }

    private void BottomSheet() {
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(getContext());
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        Button button=bottomSheetDialog.findViewById(R.id.thisisbaal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Ok",Toast.LENGTH_SHORT).show();
            }
        });
        bottomSheetDialog.show();
    }
}