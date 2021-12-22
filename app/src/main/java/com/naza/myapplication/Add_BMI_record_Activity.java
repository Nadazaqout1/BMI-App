package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Add_BMI_record_Activity extends AppCompatActivity {

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



        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        }

    }
