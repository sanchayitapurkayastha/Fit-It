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

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class AgeFragment extends Fragment {

    public AgeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: Rename and change types of parameters
    }

    private TextInputLayout age;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_age,container,false);
        age=(TextInputLayout)view.findViewById(R.id.age);
        Button b2 = (Button) view.findViewById(R.id.button2);
        b2.setOnClickListener(v -> {
            FragmentTransaction fr=getFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container,new WeightFragment());
            fr.addToBackStack(null).commit();
            Bundle bundle = new Bundle();
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