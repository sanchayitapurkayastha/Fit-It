package com.example.firebaselogin.fitit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
/*import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;*/

public class LogIn extends AppCompatActivity {

    TextInputLayout password,log_phone;
    Button forgot_pass,button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        forgot_pass=(Button)findViewById(R.id.forgot_pass);
        button_login=(Button)findViewById(R.id.button_login);

        password=(TextInputLayout)findViewById(R.id.password_login);
        log_phone=(TextInputLayout)findViewById(R.id.phone_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(v);
            }
        });
        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });
    }

    public boolean validpassword(){
        String a=password.getEditText().getText().toString();
        if(a.isEmpty()){
            password.setError("Enter your password!");
            return false;
        }else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
    public boolean validphoneNo(){
        String a=log_phone.getEditText().getText().toString();
        if(a.isEmpty()){
            log_phone.setError("Enter your phone no!");
            return false;
        }else {
            log_phone.setError(null);
            log_phone.setErrorEnabled(false);
            return true;
        }
    }
    public void check(View v){
        if( !validpassword() || !validphoneNo()){
            Toast.makeText(getApplicationContext(),"Login Unsuccessfull",Toast.LENGTH_LONG).show();
            return;
        }else{
            isUse();
        }
    }
    private void isUse() {

        String UserEnterPhoneNo=log_phone.getEditText().getText().toString().trim();
        final  String UserEnterPassword=password.getEditText().getText().toString().trim();
//
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");//pass the key here
        Query checkUser=reference.orderByChild("phoneno").equalTo(UserEnterPhoneNo);//here the while matching the name use it from the firebase chrome
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    log_phone.setError(null);
                    log_phone.setErrorEnabled(false);
                    String passwordFromDb=snapshot.child(UserEnterPassword).child("password").getValue(String.class);
                    if(passwordFromDb.equals(UserEnterPassword)){
                        log_phone.setError(null);
                        log_phone.setErrorEnabled(false);
                        String fullName=snapshot.child(UserEnterPhoneNo).child("name").getValue(String.class);
                        String fullEmail=snapshot.child(UserEnterPhoneNo).child("email").getValue(String.class);
                        String fullPhone=snapshot.child(UserEnterPhoneNo).child("phoneno").getValue(String.class);
                        String fullAddress=snapshot.child(UserEnterPhoneNo).child("address").getValue(String.class);
                        Intent intent=new Intent(getApplicationContext(),Home_page.class);
                        //passing the values got from firebase to the profile
                        //intent.putExtra("a",full_name);
                        startActivity(intent);
                    }else {
                        password.setError("Wrong Phone no");
                        password.requestFocus();
                    }
                }
                else{
                    log_phone.setError("User doesnot exits");
                    log_phone.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}