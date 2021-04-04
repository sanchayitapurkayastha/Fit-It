package com.example.firebaselogin.fitit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {

    TextInputLayout regName,regAddress,regEmail,regPhone,regPassword;
    Button regButton,regLogIn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
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

                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("users");

                //get the values from textfield
                String name=regName.getEditText().getText().toString();
                String phoneno=regPhone.getEditText().getText().toString();
                String email=regEmail.getEditText().getText().toString();
                String address=regAddress.getEditText().getText().toString();
                String password=regPassword.getEditText().getText().toString();


                UserHelperClass helperClass=new UserHelperClass(name,phoneno,email,address,password);
                reference.child(phoneno).setValue(helperClass);

                Intent intent=new Intent(getApplicationContext(),Home_page.class);
                startActivity(intent);
            }
        });
        regLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LogIn.class);
                startActivity(intent);
            }
        });
    }
}