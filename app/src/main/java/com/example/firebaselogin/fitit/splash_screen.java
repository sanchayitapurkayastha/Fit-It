package com.example.firebaselogin.fitit;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class splash_screen extends AppCompatActivity {
    private MaterialCardView card1, card2,card3,card4, logoCard;
    private TextView titleTv, subtitleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_new);

        /** Defining the hooks */
        card1 = findViewById(R.id.card_1);
        card2 = findViewById(R.id.card_2);
        card3 = findViewById(R.id.card_3);
        card4 = findViewById(R.id.card_4);
        logoCard = findViewById(R.id.logo_card);
        titleTv = findViewById(R.id.title_tv);
        subtitleTv = findViewById(R.id.subtitle_tv);


        /** Property values animator for scale animation */
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2.5f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2.5f);

        /** Object animator set up for the logo card animation */
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(logoCard, scaleX, scaleY);
        animator.setDuration(400);
        animator.setInterpolator(new AnticipateOvershootInterpolator());

        /** Object animator set up for the card1 animation */
        ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(card1, scaleX, scaleY);
        animator1.setDuration(500);
        animator1.setStartDelay(300);
        animator1.setInterpolator(new AnticipateOvershootInterpolator());


        /** Object animator set up for the card2 animation */
        ObjectAnimator animator2 = ObjectAnimator.ofPropertyValuesHolder(card2, scaleX, scaleY);
        animator2.setDuration(400);
        animator2.setRepeatCount(1);
        animator2.setRepeatMode(ObjectAnimator.REVERSE);
        animator2.setStartDelay(200);

        /** Object animator set up for the card1 animation */
        ObjectAnimator animator9 = ObjectAnimator.ofPropertyValuesHolder(card3, scaleX, scaleY);
        animator1.setDuration(500);
        animator1.setStartDelay(300);
        animator1.setInterpolator(new AnticipateOvershootInterpolator());


        /** Object animator set up for the card2 animation */
        ObjectAnimator animator10 = ObjectAnimator.ofPropertyValuesHolder(card4, scaleX, scaleY);
        animator2.setDuration(400);
        animator2.setRepeatCount(1);
        animator2.setRepeatMode(ObjectAnimator.REVERSE);
        animator2.setStartDelay(200);

        /** Object animator set up for the text view fading animation animation */
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(titleTv, View.ALPHA, 1f);
        animator3.setDuration(500);
        animator3.setStartDelay(100);

        /** Object animator set up for the text view fading animation animation */
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(subtitleTv, View.ALPHA, 1f);
        animator4.setDuration(500);
        animator4.setStartDelay(100);

        /** Object animator set up for the text view fading animation animation */
        ObjectAnimator animator5 = ObjectAnimator.ofFloat(subtitleTv, View.TRANSLATION_Y, 400f, 1f);
        animator4.setDuration(500);
        animator4.setStartDelay(100);



        /** Animator set to play them together or to play them sequentially */
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator, animator1, animator2, animator3, animator4, animator5,animator9,animator10);
        set.setDuration(1000);


        set.setDuration(4000);
        set.start();
        /** Just playing this after a time of 1 sec for testing purpose */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent= new Intent(splash_screen.this,LogIn.class);
                startActivity(intent);
                finish();

            }
        }, 4000);



    }
}

