
package com.naza.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class add_food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        EditText et_name = findViewById(R.id.add_food_et_name);
        Spinner category_spinner = findViewById(R.id.add_food_category_spinner);
        EditText et_calory = findViewById(R.id.add_food_et_calory);
        ImageView iv_img = findViewById(R.id.add_food_iv_img);
        Button bt_upload = findViewById(R.id.add_food_bt_upload);
        Button bt_save = findViewById(R.id.add_food_bt_save);


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