package com.example.firebaselogin.fitit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputLayout;


public class QuestionForItemFragment extends Fragment {

    TextInputLayout height;

    public QuestionForItemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_question_for_item,container,false);


        height=(TextInputLayout)view.findViewById(R.id.height);
        Button b1=view.findViewById(R.id.button1);


        b1.setOnClickListener(v -> {
            FragmentTransaction fr=getFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container,new AgeFragment());
            fr.addToBackStack(null).commit();
            Bundle bundle = new Bundle();
            bundle.putString("HEIGHT", height.getEditText().getText().toString());

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            SizeAnswer sizeAnswer = new SizeAnswer();
            sizeAnswer.setArguments(bundle);

            fragmentTransaction.replace(R.id.fragment_container, sizeAnswer );
            fragmentTransaction.commit();
        });
        return view;
    }
}