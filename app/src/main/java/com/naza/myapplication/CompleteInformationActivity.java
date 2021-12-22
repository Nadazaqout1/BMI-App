package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CompleteInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_information);

        RadioButton rb_male = findViewById(R.id.complete_rb_male);
        RadioButton rb_female = findViewById(R.id.complete_rb_female);
        EditText et_weight = findViewById(R.id.complete_et_weight);
        EditText et_length = findViewById(R.id.complete_et_length);
        EditText et_dob = findViewById(R.id.complete_et_dob);
        TextView tv_weight_min = findViewById(R.id.complete_tv_weight_min);
        TextView tv_weight_add = findViewById(R.id.complete_tv_weight_add);
        TextView tv_length_min = findViewById(R.id.complete_tv_length_min);
        TextView tv_length_add = findViewById(R.id.complete_tv_length_add);
        Button bt_save = findViewById(R.id.add_bmi_bt_save);


        rb_male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    Toast.makeText(getBaseContext(),  "Checked", Toast.LENGTH_LONG).show();
                else
                Toast.makeText(getBaseContext(), "Un Checked", Toast.LENGTH_LONG).show();
            }
        });



        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}