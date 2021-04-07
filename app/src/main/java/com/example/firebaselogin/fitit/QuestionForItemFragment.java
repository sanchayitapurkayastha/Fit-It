package com.example.firebaselogin.fitit;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;


public class QuestionForItemFragment extends Fragment {

    private Button b1;
    private TextInputLayout height;
    public interface FragmentHeightListener{
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_question_for_item,container,false);


        height=(TextInputLayout)view.findViewById(R.id.height);
        Button b1=view.findViewById(R.id.button1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new AgeFragment());
                fr.addToBackStack(null).commit();
                Bundle bundle = new Bundle();
                bundle.putString("ht", height.getEditText().getText().toString());
                SizeAnswer fragment = new SizeAnswer();
                fragment.setArguments(bundle);
            }
        });
        return view;
    }
}