package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        EditText et_current_status = findViewById(R.id.home_et_current_status);
        Button bt_add_food = findViewById(R.id.home_bt_add_food);
        Button bt_add_record = findViewById(R.id.home_bt_add_record);
        Button bt_view_food = findViewById(R.id.home_bt_view_food);
        TextView tv_logout =findViewById(R.id.home_tv_logout);

        bt_add_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_add_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        bt_view_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,Login.class );
                startActivity(intent);
                }
        });
    }
}