package com.example.market.Parser;
import com.example.market.ListModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("items")
    Call<List<ListModel>> getList();
}
