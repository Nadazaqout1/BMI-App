package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    private String name,email,password,rePassword;
    private boolean isValidPassword,isValidEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText et_name = findViewById(R.id.signup_et_name);
        EditText et_email = findViewById(R.id.signup_et_name);
        EditText et_password = findViewById(R.id.signup_et_password);
        EditText et_re_password = findViewById(R.id.signup_et_repassword);
        TextView tv_login = findViewById(R.id.signup_tv_login);
        Button bt_create = findViewById(R.id.signup_bt_create);

        tv_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(signup.this,Login.class);
                startActivity(intent);
            }
        });

        bt_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=et_name.getText().toString();
                email=et_email.getText().toString();
                password=et_password.getText().toString();
                rePassword=et_re_password.getText().toString();

                // check if all fields filled
                if(name.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty())
                    Toast.makeText(getBaseContext(),"please fill all fields",Toast.LENGTH_SHORT).show();
                    // email validation
                else if(!(isValidEmail=emailValidation(email)))
                    Toast.makeText(getBaseContext(),"Email is not Valid",Toast.LENGTH_SHORT).show();
                else{
                    // Two passwords matches
                    isValidPassword=confirmPassword(password,rePassword);
                    if(!isValidPassword){
                        Toast.makeText(getBaseContext(),"The Entered Passwords Doesn't Match, Try Again!",Toast.LENGTH_SHORT).show();
                    }else{
                        //open Complete SignUp layout
                        Intent completeSignUpIntent= new Intent(signup.this, CompleteInformationActivity.class);
                        completeSignUpIntent.putExtra("name",name);
                        completeSignUpIntent.putExtra("email",email);
                        completeSignUpIntent.putExtra("password",password);
                        startActivity(completeSignUpIntent);
                    }
                }

            }
        });






    }
}