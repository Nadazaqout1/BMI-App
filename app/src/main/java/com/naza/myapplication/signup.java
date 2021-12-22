package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signup extends AppCompatActivity {


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

            }
        });






    }
}