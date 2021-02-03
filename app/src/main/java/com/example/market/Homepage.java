package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {
    Button Add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Add=(Button) findViewById(R.id.button1);
        Add.setOnClickListener(new View.OnClickListener() {
//            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Homepage.this,Additems.class);//move to next page
                startActivity(intent);
            }
    });
    }
}
