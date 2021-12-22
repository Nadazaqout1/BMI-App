package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Edit_Food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);


        EditText et_name = findViewById(R.id.Edit_Food_et_name);
        EditText et_category = findViewById(R.id.Edit_Food_et_category);
        EditText et_calory = findViewById(R.id.Edit_Food_et_calory);
        ImageView iv_photo = findViewById(R.id.Edit_Food_iv_photo);
        Button bt_save = findViewById(R.id.Edit_Food_bt_save);
        Button bt_upload = findViewById(R.id.Edit_Food_bt_upload);



        bt_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}