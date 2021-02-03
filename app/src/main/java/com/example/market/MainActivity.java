package com.example.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {
   EditText username,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         username = (EditText) findViewById(R.id.editText1);
         password = (EditText) findViewById(R.id.editText2);
         login=(Button) findViewById(R.id.button1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username.getText().toString();
                String pwd=password.getText().toString();
                if(TextUtils.isEmpty(username.getText())){
                    Toast.makeText(getApplicationContext(),"enter username",Toast.LENGTH_SHORT).show();
                }
               else if(TextUtils.isEmpty(password.getText())){
                    Toast.makeText(getApplicationContext(),"enter password",Toast.LENGTH_SHORT).show();
                }
               else{
                   if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin123")) {
                       Intent intent=new Intent(MainActivity.this,Homepage.class);//move to next page
                       startActivity(intent);
                    //correcct password
                } else {
                    //wrong password
                       Toast.makeText(getApplicationContext(),"Invalid Username or password",Toast.LENGTH_LONG).show();
                }

                }

            }
        });

    }

}