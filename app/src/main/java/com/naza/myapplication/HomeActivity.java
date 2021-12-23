package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    User signed_user;
    ArrayList<BMIRecord> bmi_record;
    OldStatusAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView tv_name= findViewById(R.id.home_tv_name);
        EditText et_current_status = findViewById(R.id.home_et_current_status);
        RecyclerView rv_oldStatus = findViewById(R.id.home_rv_oldStatus);
        Button bt_add_food = findViewById(R.id.home_bt_add_food);
        Button bt_add_record = findViewById(R.id.home_bt_add_record);
        Button bt_view_food = findViewById(R.id.home_bt_view_food);
        TextView tv_logout =findViewById(R.id.home_tv_logout);

        Intent intent= getIntent();
        signed_user= (User) intent.getSerializableExtra("signed_user");

        String name=signed_user.getName();
        BMIRecord user_bmi=signed_user.getBmis().get(0);
        Float weight=user_bmi.getWeight();
        Float length=user_bmi.getLength();
        String status=user_bmi.getStatus();
        LocalDate localDate= user_bmi.getDate();
        LocalTime localTime= user_bmi.getTime();

        tv_name.setText("Hi, "+name);

        //status Message
        String changeMessage = signed_user.BMIRChange();
        et_current_status.setText(status+"("+ changeMessage + ")");


        bmi_record=new ArrayList<BMIRecord>();
        bmi_record.add(user_bmi);


        adapter=new OldStatusAdapter(bmi_record);
        RecyclerView.LayoutManager adapterManager = new LinearLayoutManager(getBaseContext());

        rv_oldStatus.setHasFixedSize(true);
        rv_oldStatus.setLayoutManager(adapterManager);
        rv_oldStatus.setAdapter(adapter);


        bt_add_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addFoodIntent = new Intent(HomeActivity.this,add_food.class);
                startActivity(addFoodIntent);
            }
        });

        bt_add_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addRecordIntent = new Intent(HomeActivity.this,Add_BMI_record_Activity.class);
                addRecordIntent.putExtra("signed_user", signed_user);
                startActivity(addRecordIntent);
            }
        });


        bt_view_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewFoodIntent = new Intent(HomeActivity.this,Food_List.class);
                startActivity(viewFoodIntent);
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