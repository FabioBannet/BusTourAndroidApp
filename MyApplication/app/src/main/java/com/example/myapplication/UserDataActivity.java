package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DAL.RetrofitInstance;
import com.example.myapplication.DAL.dto.BuyerDTO;
import com.example.myapplication.DAL.dto.TicketDTO;
import com.example.myapplication.DAL.entities.Buyer;
import com.example.myapplication.DAL.entities.Ticket;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDataActivity extends AppCompatActivity {

    private Ticket ticket;

    private EditText etFIO;
    private EditText etMobileNumber;
    private Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        ticket = (Ticket) getIntent().getSerializableExtra("ticket");

        initViews();
    }

    private void initViews() {
        etFIO = findViewById(R.id.etFIO);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        btnOrder = findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(this::order);
    }

    private void order(View view) {
        reserveTicket();
    }

    private void  reserveTicket(){

        Buyer  buyerDTO = new Buyer();
        buyerDTO.setFio(etFIO.getText().toString());
        buyerDTO.setMobile_number(etMobileNumber.getText().toString());


        RetrofitInstance.getInstance()
                .getBuyerAPIInstance()
                .post(buyerDTO)
                .enqueue(new Callback<Buyer>() {
                    @Override
                    public void onResponse(Call<Buyer> call, Response<Buyer> response) {
                        if(response.isSuccessful())
                        {
                            if(response.body() != null)
                            {
                                Buyer buyer = response.body();
                                putUserIntoTicket(buyer);
                                finish();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Buyer> call, Throwable t) {
                        Toast.makeText(UserDataActivity.this, "The user hasn't been reserved!", Toast.LENGTH_LONG).show();
                        Log.d("myApp", t.toString());

                    }
                });
    }

    private void putUserIntoTicket(Buyer buyer){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticket.getId());
        ticketDTO.setDirection(ticket.getDirection());
        ticketDTO.setDate(ticket.getDate());
        ticketDTO.setDeparture_time(ticket.getDeparture_time());
        ticketDTO.setArrival_time(ticket.getArrival_time());
        ticketDTO.setSeat(ticket.getSeat());
        ticketDTO.setPrice(ticket.getPrice());
        ticketDTO.setBuyer_id(buyer.getId());

        RetrofitInstance.getInstance()
                .getTicketsAPIInstance()
                .put(ticketDTO)
                .enqueue(new Callback<Ticket>() {
                    @Override
                    public void onResponse(Call<Ticket> call, Response<Ticket> response) {
                        if(response.isSuccessful()) {
                            if (response.body() != null) {
                                ticket = response.body();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Ticket> call, Throwable t) {
                        Toast.makeText(UserDataActivity.this, "The ticket hasn't been reserved!", Toast.LENGTH_LONG).show();
                    }
                });
    }
}