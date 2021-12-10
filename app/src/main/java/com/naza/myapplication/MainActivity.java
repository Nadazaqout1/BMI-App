package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next = findViewById(R.id.next);

        private final long Time_Ms=5000;
        private countDownTimer counter;



        counter=new CountDownTimer(Time_Ms,CountDownInterval:1000){
            public void onTick (long millisUntilFinished){
            }
            public void onFinish(){
                Intent x= new Intent(createPackageContext:MainActivity.this,Login.class)
                finish();
                startActivity(x);
            }
        };
        start();

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){ moveToLogin();}
        });
    }


}
