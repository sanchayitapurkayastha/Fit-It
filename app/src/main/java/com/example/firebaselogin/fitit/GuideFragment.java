package com.example.firebaselogin.fitit;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class GuideFragment extends Fragment {

    private OnBoardingAdapter onBoardingAdapter;
    private LinearLayout layoutOnBoardingIndicators;
    private MaterialButton buttonOnBoardingAction;
    private ViewPager2 viewPager;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public GuideFragment() {
        // Required empty public constructor
    }
    public static GuideFragment newInstance(String param1, String param2) {
        GuideFragment fragment = new GuideFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        viewPager=view.findViewById(R.id.onBoardingViewPager);
        layoutOnBoardingIndicators=view.findViewById(R.id.layoutOnBoardingIndicator);
        buttonOnBoardingAction=view.findViewById(R.id.buttonOnBoardingAction);
        viewPager.setAdapter(onBoardingAdapter);
        setupOnBoardingItems();
        setOnBoardingIndicators();
        setCurrentOnBoardingIndicator(0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnBoardingIndicator(position);
            }
        });
        buttonOnBoardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPager.getCurrentItem()+1 < onBoardingAdapter.getItemCount()){
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }else {
                    startActivity(new Intent(getActivity().getApplicationContext(), Home_page.class));
                    getActivity().finish();
                }
            }
        });
        return view;
    }
    private void setupOnBoardingItems(){
        List<OnBoardingItem> onBoardingItem = new ArrayList<>();

        OnBoardingItem one=new OnBoardingItem();
        one.setTitle("Hello hello");
        one.setDescription("Bhat Khala!!");
        one.setImage(R.raw.thinking);

        OnBoardingItem two=new OnBoardingItem();
        two.setTitle("hi hi");
        two.setDescription("ki di khala!!");
        two.setImage(R.raw.reddressgirl);

        OnBoardingItem three=new OnBoardingItem();
        three.setTitle("ok then xui thake");
        three.setDescription("tata Good Night!!");
        three.setImage(R.raw.shop);

        onBoardingItem.add(one);
        onBoardingItem.add(two);
        onBoardingItem.add(three);

        onBoardingAdapter = new OnBoardingAdapter(onBoardingItem);
    }
    private   void  setOnBoardingIndicators(){
        ImageView[] indicators= new ImageView[onBoardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for(int i=0;i<indicators.length;i++){
            indicators[i]=new ImageView(getActivity().getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(),R.drawable.on_boarding_indicator_inactive));
            indicators[i].setLayoutParams(layoutParams);
            layoutOnBoardingIndicators.addView(indicators[i]);
        }
    }
    private void setCurrentOnBoardingIndicator(int index){
        int childCount = layoutOnBoardingIndicators.getChildCount();
        for(int i=0;i<childCount;i++){
            ImageView imageView=(ImageView)layoutOnBoardingIndicators.getChildAt(i);
            if(i == index){
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(),R.drawable.on_boarding_indicator_active));
            }else{
                imageView.setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(),R.drawable.on_boarding_indicator_inactive));
            }
        }
        if(index == onBoardingAdapter.getItemCount()-1){
            buttonOnBoardingAction.setText("Start");
        }else{
            buttonOnBoardingAction.setText("Next");
        }
    }
}