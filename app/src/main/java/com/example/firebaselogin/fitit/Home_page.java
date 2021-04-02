package com.example.firebaselogin.fitit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_page extends AppCompatActivity implements View.OnClickListener {

    public CardView c1,c2,c3,c4,c5,c6,c7,c8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //bottom navigation bar
        BottomNavigationView bottomNavigationViewHome =findViewById(R.id.bottom_navigation);
        bottomNavigationViewHome.setOnNavigationItemSelectedListener(navListener);

//      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

        c1=(CardView)findViewById(R.id.card1);
        c2=(CardView)findViewById(R.id.card2);
        c3=(CardView)findViewById(R.id.card3);
        c4=(CardView)findViewById(R.id.card4);
        c5=(CardView)findViewById(R.id.card5);
        c6=(CardView)findViewById(R.id.card6);
        c7=(CardView)findViewById(R.id.card7);
        c8=(CardView)findViewById(R.id.card8);

        c1.setOnClickListener(this);
        c2.setOnClickListener(this);


    }
    //Bottom navBar
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
                    selectedFragment=new GuidePage2();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return  true;

        }
    };

    @Override
    public void onClick(View v) {
        Fragment selectedFragment= new QuestionForItemFragment();
         getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
    }
}