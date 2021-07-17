package com.example.yousefgrad;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;



public class option extends AppCompatActivity {
    ImageButton imgb1,imgb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Configuration config = getResources().getConfiguration();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_option);

        imgb1 =(ImageButton) findViewById(R.id.imgbutton1);
        imgb2=(ImageButton)findViewById(R.id.imgbutton2);
        imgb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(option.this,login.class);
                startActivity(intToHome);
            }
        });
        imgb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToHome = new Intent(option.this, logindriver.class);
                startActivity(intToHome);
            }
        });

    }
}