package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_next = findViewById(R.id.splash_tv_next);


        tv_next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { openLogin(); }
        });

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                openLogin();
            }
        }
        ,5000);
    }

    public void openLogin(){
        Intent i=new Intent(getBaseContext(),Login.class);
        startActivity(i);
    }

    }



