package com.example.firebaselogin.fitit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class GiftFragment extends Fragment {
    @Nullable
    Button b_gift;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_giftpage,container,false);

        b_gift=(Button)v.findViewById(R.id.gift_button);
        b_gift.setOnClickListener(v1 -> {
            FragmentTransaction fr=getFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container,new GiftListFragment());
            fr.addToBackStack(null).commit();
        });

        return  v;
    }
}
