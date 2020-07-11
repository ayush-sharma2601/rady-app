package com.example.radyapp.DoctorSide.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.radyapp.DoctorSide.Fragments.DoctorInventoryFragment;
import com.example.radyapp.DoctorSide.Fragments.DoctorScheduleFragment;
import com.example.radyapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class DoctorHome extends AppCompatActivity {


    DrawerLayout drawerLayout;
    ImageView menuBtn;
    FrameLayout frameLayout;
    AnimatedBottomBar bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
        attachID();

        loadFragment(new DoctorScheduleFragment());


        bottomNavigationView.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NotNull AnimatedBottomBar.Tab tab1) {
                switch (tab.getId()){
                    case R.id.doctor_schedule:{
                        loadFragment(new DoctorScheduleFragment());
                        Toast.makeText(DoctorHome.this,"0",Toast.LENGTH_SHORT).show();
                    }
                    case R.id.doctor_inventory:{
                        loadFragment(new DoctorInventoryFragment());
                        Toast.makeText(DoctorHome.this,"1",Toast.LENGTH_SHORT).show();
                    }
                    case R.id.doctor_summon:{
                        Toast.makeText(DoctorHome.this,"2",Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onTabReselected(int i, @NotNull AnimatedBottomBar.Tab tab) {
                switch (i){
                    case 0:{
                        loadFragment(new DoctorScheduleFragment());
                    }
                    case 1:{
                        loadFragment(new DoctorInventoryFragment());
                    }
                    case 2:{

                    }
                }
            }
        });

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    private void attachID() {
        drawerLayout = findViewById(R.id.drawer_layout);
        menuBtn = findViewById(R.id.menu_btn);
        frameLayout = findViewById(R.id.frame_layout);
        bottomNavigationView = findViewById(R.id.bottom_bar);
    }


    public void DoctorProfile(MenuItem item) {
    }

    public void DoctorNotices(MenuItem item) {
    }

    public void DoctorLogout(MenuItem item) {
    }

    public void loadFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}