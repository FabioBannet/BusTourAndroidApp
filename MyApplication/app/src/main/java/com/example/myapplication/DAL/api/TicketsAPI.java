package com.example.myapplication.DAL.api;

import com.example.myapplication.DAL.dto.TicketDTO;
import com.example.myapplication.DAL.entities.Ticket;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface TicketsAPI {

    @GET("/ticket/available/{date}")
    Call<List<Ticket>> getAll(@Path("date")String date);


    @GET("/ticket/{id}")
    Call<Ticket> get(@Path("id")int ticketID);

    @PUT("/ticket")
    public Call<Ticket> put(@Body TicketDTO ticket);
}
