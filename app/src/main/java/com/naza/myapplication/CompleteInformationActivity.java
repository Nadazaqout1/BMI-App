package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;



public class CompleteInformationActivity extends AppCompatActivity {

    private float weight,length;
    private String gender,dob;
    private String name,email,password;
    private User user;
    private   ArrayList<BMIRecord> bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_information);

        RadioGroup rg_gender = findViewById(R.id.complete_rg_gender);
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




        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        password = intent.getStringExtra("password");


        tv_weight_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_weight.getText().toString()==null)
                    weight=0;
                weight=Float.parseFloat(et_weight.getText().toString());
                weight= (float) (weight+1);
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



        bt_save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                gender=getSelectedGender(rg_gender);
                weight=Float.parseFloat(et_weight.getText().toString());
                length=Float.parseFloat(et_length.getText().toString());
                dob=et_dob.getText().toString();


                if(gender.equals("null") || dob.isEmpty() || et_weight.getText().toString().isEmpty() || et_length.getText().toString().isEmpty() )
                    Toast.makeText(getBaseContext(),"please fill all fields",Toast.LENGTH_SHORT).show();
                else{
                    //create new user
                    LocalDate localDate= java.time.LocalDate.now();
                    LocalTime localTime= java.time.LocalTime.now();
                    BMIRecord first_bmi=new BMIRecord(weight,length,localDate,localTime);
                    bmi=new ArrayList<BMIRecord>();
                    bmi.add(first_bmi);
                    user=new User(name,email,password,gender,dob,bmi);

                    //home intent
                    Intent home_intent=new Intent(getBaseContext(),HomeActivity.class);
                    home_intent.putExtra("signed_user", user);
                    startActivity(home_intent);
                }
            }
        });

    }


    // get selected gender method
         public String getSelectedGender(RadioGroup rg_gender){
        String gender=null;
        int selected_gender_id=rg_gender.getCheckedRadioButtonId();
        if(selected_gender_id == -1){
            gender="null";
            return gender;
        }else{
            RadioButton selected_rb_gender=(RadioButton) findViewById(selected_gender_id);
            gender=selected_rb_gender.getText().toString();
            return  gender;
        }

    }




    }
}