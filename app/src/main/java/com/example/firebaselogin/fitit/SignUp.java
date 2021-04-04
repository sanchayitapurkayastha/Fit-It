package com.example.firebaselogin.fitit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    TextInputLayout regName,regAddress,regEmail,regPhone,regPassword;
    Button regButton,regLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        regName=(TextInputLayout)findViewById(R.id.full_name_signin);
        regEmail=(TextInputLayout)findViewById(R.id.email_signin);
        regPhone=(TextInputLayout)findViewById(R.id.phone_signin);
        regAddress=(TextInputLayout)findViewById(R.id.Address_signin);
        regPassword=(TextInputLayout)findViewById(R.id.password_signin);

        regButton=(Button)findViewById(R.id.button_signin);
        regLogIn=(Button)findViewById(R.id.button_login_signin);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}