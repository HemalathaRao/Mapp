package com.example.market.RestClient;

import android.content.Context;

import com.example.market.Constants;
import com.example.market.Parser.RestApi;
import com.google.gson.Gson;
        import java.io.IOException;
        import okhttp3.Interceptor;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;


public class RestClient {
    private  static  RestClient restClient;
    private RestApi restApi;
    private  RestClient (Context context){
        restApi=setupApI(context);
    }

    public  synchronized static RestClient getInstance(Context context){
        if (restClient==null){
            restClient=new RestClient(context.getApplicationContext());
        }
        return restClient;
    }

    public RestApi getRestApi() {
        return restApi;
    }

    private RestApi setupApI(final Context context){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Interceptor interceptor=new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder();
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };

        httpClient.addInterceptor(interceptor);
        httpClient.interceptors().add(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

        OkHttpClient client = httpClient.build();
        Gson gson=new Gson();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Constants.Baseurl).
                client(client).
                addConverterFactory(GsonConverterFactory.create(gson)).build();
        return retrofit.create(RestApi.class);
    }
}