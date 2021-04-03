package com.example.firebaselogin.fitit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

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

//      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).addToBackStack(null).commit();

        c1= findViewById(R.id.card1);
        c2= findViewById(R.id.card2);
        c3= findViewById(R.id.card3);
        c4= findViewById(R.id.card4);
        c5= findViewById(R.id.card5);
        c6= findViewById(R.id.card6);
        c7= findViewById(R.id.card7);
        c8= findViewById(R.id.card8);

        c1.setOnClickListener(this);
        c2.setOnClickListener(this);


    }
    //Bottom navBar
    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
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
        assert selectedFragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).addToBackStack(null).commit();
        return  true;

    };

    @Override
    public void onClick(View v) {
        Fragment selectedFragment= new QuestionForItemFragment();
         getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).addToBackStack(null).commit();
    }
}