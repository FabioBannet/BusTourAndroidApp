package com.example.myapplication.DAL.api;

import com.example.myapplication.DAL.dto.BuyerDTO;
import com.example.myapplication.DAL.entities.Buyer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BuyerAPI {
    @GET("/buyer")
    Call<List<Buyer>> getAll();

    @GET("/buyer/{id}")
    Call<Buyer> get(@Path("id")int buyerID);

    @POST("/buyer")
    public Call<Buyer> post(@Body Buyer buyerDTO);

    @PUT("/buyer")
    public Call<Buyer> put(@Body BuyerDTO buyer);
}
