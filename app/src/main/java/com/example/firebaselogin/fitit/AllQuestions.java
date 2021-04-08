package com.example.firebaselogin.fitit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputLayout;


public class AllQuestions extends Fragment {

    public AllQuestions() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: Rename and change types of parameters
    }

    private TextInputLayout height,age,weight;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmnet_allquestions,container,false);
        height=(TextInputLayout)view.findViewById(R.id.height);
        age=(TextInputLayout)view.findViewById(R.id.age);
        weight=(TextInputLayout)view.findViewById(R.id.weight);

        Button b2=(Button)view.findViewById(R.id.button2);
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(),ProductList.class));
//            }
//        });
        b2.setOnClickListener(v -> {
            FragmentTransaction fr=getFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container,new SizeAnswer());
            fr.addToBackStack(null).commit();

            Bundle bundle = new Bundle();
            bundle.putString("HEIGHT", height.getEditText().getText().toString());
            bundle.putString("WEIGHT", weight.getEditText().getText().toString());
            bundle.putString("AGE", age.getEditText().getText().toString());

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            SizeAnswer sizeAnswer = new SizeAnswer();
            sizeAnswer.setArguments(bundle);

            fragmentTransaction.replace(R.id.fragment_container,sizeAnswer );
            fragmentTransaction.commit();

        });
        return  view;
    }
}