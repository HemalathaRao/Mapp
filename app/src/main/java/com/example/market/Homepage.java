package com.example.market;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.market.RestClient.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Homepage extends AppCompatActivity {
    Button Add;
    RecyclerView Recycle;
    Adapter mAdapter;
    List<ListModel> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Add=(Button) findViewById(R.id.button1);
        Recycle=(RecyclerView) findViewById(R.id.recycler);
        Recycle.setLayoutManager(new LinearLayoutManager(this));
        Recycle.setAdapter(mAdapter = new Adapter(getApplicationContext(),list));

        Add.setOnClickListener(new View.OnClickListener() {
//            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Homepage.this,Additems.class);//move to next page
                startActivity(intent);
            }
    });
        getdata();

    }

    private void getdata() {
        RestClient.getInstance(getApplicationContext())
                .getRestApi()
                .getList()
                .enqueue(new Callback<List<ListModel>>() {
                    @Override
                    public void onResponse(Call<List<ListModel>> call, Response<List<ListModel>> response) {
                        if (response.code() == 200) {
                            list.addAll(response.body());
                            mAdapter.notifyDataSetChanged();

                        } else {

                        }
                    }
                    @Override
                    public void onFailure(Call<List<ListModel>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Please Check Internet Connection", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}
