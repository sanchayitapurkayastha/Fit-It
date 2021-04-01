package com.example.firebaselogin.fitit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //bottom navigation bar
        BottomNavigationView bottomNavigationViewHome =findViewById(R.id.bottom_navigation);
        bottomNavigationViewHome.setOnNavigationItemSelectedListener(navListener);

//      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;

            switch (item.getItemId()){
                case R.id.nav_profile:
                    selectedFragment=new ProfileFragment();
                    break;
                case R.id.nav_gift:
                    selectedFragment=new GiftFragment();
                    break;
                case R.id.nav_guide:
                    selectedFragment=new GuideFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return  true;

        }
    };
}