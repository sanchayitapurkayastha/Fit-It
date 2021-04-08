package com.example.firebaselogin.fitit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputLayout;

public class WeightFragment extends Fragment {

    private TextInputLayout weight;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_weight,container,false);
        weight=(TextInputLayout)view.findViewById(R.id.weight);
        Button b3 = (Button) view.findViewById(R.id.button3);
        b3.setOnClickListener(v -> {
//            FragmentTransaction fr=getFragmentManager().beginTransaction();
//            fr.replace(R.id.fragment_container,new ItemListFragment());
//            fr.addToBackStack(null).commit();

            Bundle bundle = new Bundle();
            bundle.putString("WEIGHT", weight.getEditText().getText().toString());

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