package com.example.myapplication.DAL;

import com.example.myapplication.DAL.api.BuyerAPI;
import com.example.myapplication.DAL.api.TicketsAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    // https://stackoverflow.com/questions/18341652/connect-failed-econnrefused/18357646
    public static final String BASE_URL = "http://10.0.2.2:8080";

    private static RetrofitInstance retrofitInstance;
    private Retrofit retrofit;

    private RetrofitInstance()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitInstance getInstance()
    {
        return retrofitInstance == null?
                 retrofitInstance = new RetrofitInstance()
                :retrofitInstance;
    }

    public TicketsAPI getTicketsAPIInstance()
    {
        return retrofit.create(TicketsAPI.class);
    }

    public BuyerAPI getBuyerAPIInstance()
    {
        return retrofit.create(BuyerAPI.class);
    }

}
