package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.DAL.RetrofitInstance;
import com.example.myapplication.DAL.dto.TicketDTO;
import com.example.myapplication.DAL.entities.Ticket;
import com.example.myapplication.adapter.CustomAdapter;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Order_Activity extends AppCompatActivity {

    private RecyclerView recView;

    private String direction;
    private String selected_date;
    private List<Ticket> tickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        direction = getIntent().getStringExtra(MainActivity.DIRECTION);
        selected_date = getIntent().getStringExtra(MainActivity.SELECTED_DATE);

        recView = findViewById(R.id.recView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            getTickets();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void setAdapter() {
        CustomAdapter adapter = new CustomAdapter(tickets, this);

        int currentOrientation = getResources().getConfiguration().orientation;

        if(currentOrientation == Configuration.ORIENTATION_LANDSCAPE){
            recView.setLayoutManager(new GridLayoutManager(this,2));
        }else{
            recView.setLayoutManager(new GridLayoutManager(this, 1));
        }

        recView.setAdapter(adapter);
    }

    private void findDirections(){
        String[] arr = getResources().getStringArray(R.array.city_routes);

        List<Ticket> ticketsForDirection = new ArrayList<>();

        tickets.forEach(ticket -> {
            if(ticket.getDirection().equals(direction))
            {
                ticketsForDirection.add(ticket);
            }
        });

    }

    private void getTickets() {

        tickets = new ArrayList<>();

        RetrofitInstance.getInstance()
                .getTicketsAPIInstance()
                .getAll(selected_date)
                .enqueue(new Callback<List<Ticket>>() {
                    @Override
                    public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {

                        if(response.isSuccessful()) {

                            if(response.body() != null) {

                                tickets = response.body();

                                findDirections();

                                setAdapter();
                            }
                            else {
                                Toast.makeText(Order_Activity.this, " ResponseCode = " + response.code(), Toast.LENGTH_LONG).show();
                                Log.d("myApp", "The Response.Body is null!");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Ticket>> call, Throwable t) {

                        Toast.makeText(Order_Activity.this, " Error tickets download .", Toast.LENGTH_LONG).show();
                        Log.d("myApp", "Exception: " + t.getLocalizedMessage());
                    }
                });

    }
}