package com.trakntell.bluetooth2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.trakntell.bluetooth2.databinding.ActivitySignupPageBinding;

public class SignupPage extends AppCompatActivity {
    ActivitySignupPageBinding activitySignupPageBinding;
    private String name, phoneNumber, address, password, email;
    private final String regexName = "([a-zA-Z]{4,})";
    private final String regexAddress = "([a-zA-Z]{10,})";
    private final String regexEmail = "((.+)@(.+))";
    private final String regexPhoneNumber = "((0/91)?[7-9][0-9]{9})";
    private final String regexPassword = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,15})";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignupPageBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup_page);
        activitySignupPageBinding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = activitySignupPageBinding.etName.getText().toString().trim();
                address = activitySignupPageBinding.etAddress.getText().toString().trim();
                email = activitySignupPageBinding.etEmail.getText().toString().trim();
                phoneNumber = activitySignupPageBinding.etPhoneNumber.getText().toString().trim();
                password = activitySignupPageBinding.etPassword.getText().toString().trim();
                View focusView;

                if (name.isEmpty()) {
                    activitySignupPageBinding.etName.setError("Name must be mention");
                    focusView = activitySignupPageBinding.etName;
                } else if (!name.matches(regexName)) {
                    Toast.makeText(SignupPage.this, "Name should be at least 4 characters", Toast.LENGTH_SHORT).show();
                    activitySignupPageBinding.etName.setError("");
                    focusView = activitySignupPageBinding.etName;

                } else if (address.isEmpty()) {
                    activitySignupPageBinding.etAddress.setError("Address must be mention");
                    focusView = activitySignupPageBinding.etAddress;
                } else if (!address.matches(regexAddress)) {
                    Toast.makeText(SignupPage.this, "Address should be at least 10 characters", Toast.LENGTH_SHORT).show();
                    activitySignupPageBinding.etAddress.setError("");
                    focusView = activitySignupPageBinding.etAddress;


                } else if (email.isEmpty()) {
                    activitySignupPageBinding.etEmail.setError("Email must be mention");
                    focusView = activitySignupPageBinding.etEmail;
                }  else if (!email.matches(regexEmail)){
                    Toast.makeText(SignupPage.this, "Email should be a valid email address", Toast.LENGTH_SHORT).show();
                    activitySignupPageBinding.etEmail.setError("");
                    focusView = activitySignupPageBinding.etEmail;


                }else if (phoneNumber.isEmpty()) {
                    activitySignupPageBinding.etPhoneNumber.setError("Phone Number must be mention");
                    focusView = activitySignupPageBinding.etPhoneNumber;
                }  else if (!phoneNumber.matches(regexPhoneNumber)){
                    Toast.makeText(SignupPage.this, "Phone number should be at least 10 number + country code", Toast.LENGTH_SHORT).show();
                    activitySignupPageBinding.etPhoneNumber.setError("");
                    focusView = activitySignupPageBinding.etPhoneNumber;



                }else if (password.isEmpty()) {
                    activitySignupPageBinding.etPassword.setError("Password must be mention");
                    focusView = activitySignupPageBinding.etPassword;
                } else if (!password.matches(regexPassword)){
                    Toast.makeText(SignupPage.this, "Password must contain one upper character, " +
                                                                  "one lower character and a number." +
                                                                  " Max length 15 and min length 8"
                                                                  , Toast.LENGTH_SHORT).show();
                    activitySignupPageBinding.etPassword.setError("");
                    focusView = activitySignupPageBinding.etPassword;
                }



                else {
                    User user=new User(name,address,email,phoneNumber,password);
                    startnewActivity(user);
                }

            }
        });

    }
    public void startnewActivity(User user){
        startActivity(new Intent(SignupPage.this,MainActivity.class));
    }
}
