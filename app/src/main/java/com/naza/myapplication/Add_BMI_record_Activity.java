package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;

public class Add_BMI_record_Activity extends AppCompatActivity {

    private float weight,length;
    private User signed_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bmi_record);


        EditText et_weight = findViewById(R.id.add_bmi_et_weight);
        EditText et_length = findViewById(R.id.add_bmi_et_length);
        EditText et_date = findViewById(R.id.  add_bmi_et_date);
        EditText et_time = findViewById(R.id.add_bmi_et_time);
        TextView tv_weight_min = findViewById(R.id.add_bmi_tv_weight_min);
        TextView tv_weight_add = findViewById(R.id.add_bmi_tv_weight_add);
        TextView tv_length_min = findViewById(R.id.add_bmi_tv_length_min);
        TextView tv_length_add = findViewById(R.id.add_bmi_tv_length_add);
        Button bt_save = findViewById(R.id.add_bmi_bt_save);


        tv_weight_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_weight.getText().toString() == null)
                    weight = 0;
                weight = Float.parseFloat(et_weight.getText().toString());
                weight = (float) (weight + 1);
                et_weight.setText(Float.toString(weight));
            }
            });

        tv_weight_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_weight.getText().toString()==null)
                    weight=0;
                weight=Float.parseFloat(et_weight.getText().toString());
                if(weight>0.00){
                    weight= (float) (weight-1.00);
                    et_weight.setText(Double.toString(weight));
                }
            }
        });

        tv_length_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_length.getText().toString()==null)
                    length=0;
                length=Float.parseFloat(et_length.getText().toString());
                length= (float) (length+1.00);
                et_length.setText(Double.toString(length));
            }
        });


        tv_length_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(length>0.00){
                    if(et_length.getText().toString()==null)
                        length=0;
                    length=Float.parseFloat(et_length.getText().toString());
                    length= (float) (length-1.00);
                    et_length.setText(Double.toString(length));
                }
            }
        });



        Intent intent=getIntent();
        signed_user= (User) intent.getSerializableExtra("user");

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float weight=Float.parseFloat(et_weight.getText().toString());
                float length=Float.parseFloat(et_length.getText().toString());
                LocalDate date= LocalDate.parse(et_date.getText().toString());
                LocalTime time= LocalTime.parse(et_time.getText().toString());

                BMIRecord new_bmi = new BMIRecord(weight,length,date,time);
                signed_user.setBmi(new_bmi);

                Intent homeIntent = new Intent(getBaseContext(),HomeActivity.class);
                startActivity(homeIntent);

            }
        });


        }

    }
