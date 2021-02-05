package com.example.market;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Additems extends AppCompatActivity {
    Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additems);
        Back=(Button) findViewById(R.id.button2);
        Back.setOnClickListener(new View.OnClickListener() {
            //            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Additems.this,Homepage.class);//move to next page
                startActivity(intent);
            }
        });
    }
}
