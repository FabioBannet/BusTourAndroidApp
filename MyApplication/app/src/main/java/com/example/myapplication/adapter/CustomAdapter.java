package com.example.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DAL.dto.TicketDTO;
import com.example.myapplication.Order_Activity;
import com.example.myapplication.R;
import com.example.myapplication.DAL.entities.Ticket;
import com.example.myapplication.UserDataActivity;


import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    public static final String SEPARATOR= " - ";
    private static final String BTN_TEXT = "Придбати за ";
    private static final String AVAILABLE_SEATS = "Available seats: ";

    private List<Ticket> localDataSet;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCityFrom;
        private TextView tvCityTo;
        private TextView tvDepartureTime;
        private TextView tvArrivalTime;
        private TextView tvAvailableSeats;
        private Button btnOrder;

        public ViewHolder(@NonNull View view) {
            super(view);

            tvCityFrom = (TextView) view.findViewById(R.id.tvCityFrom);
            tvCityTo = (TextView) view.findViewById(R.id.tvCityTo);
            tvDepartureTime = (TextView) view.findViewById(R.id.tvDepartureTime);
            tvArrivalTime = (TextView) view.findViewById(R.id.tvArrivalTime);
            tvAvailableSeats = (TextView) view.findViewById(R.id.tvAvailableSeats);
            btnOrder = (Button) view.findViewById(R.id.btnOrder);
        }



        public TextView getTvAvailableSeats() {
            return tvAvailableSeats;
        }

        public TextView getTvCityFrom() {
            return tvCityFrom;
        }

        public TextView getTvCityTo() {
            return tvCityTo;
        }

        public TextView getTvDepartureTime() {
            return tvDepartureTime;
        }

        public TextView getTvArrivalTime() {
            return tvArrivalTime;
        }

        public Button getBtnOrder() {
            return btnOrder;
        }
    }

    public CustomAdapter(List<Ticket> dataSet, Context context) {

        localDataSet = dataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ticket_item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {



        Ticket ticket = localDataSet.get(position);
        String dir =  ticket.getDirection();
        int index = dir.indexOf(SEPARATOR);
        String fCity = dir.substring(0,index);
        String sCity = dir.substring(index + SEPARATOR.length());

        //DrawableTickets();

        viewHolder.getTvCityFrom().setText(fCity);
        viewHolder.getTvCityTo().setText(sCity);
        viewHolder.getTvDepartureTime().setText(ticket.getDeparture_time());
        viewHolder.getTvArrivalTime().setText(ticket.getArrival_time());
        viewHolder.getTvAvailableSeats().setText(ticket.getSeat());
        viewHolder.getBtnOrder().setText(BTN_TEXT + ticket.getPrice());


        viewHolder.getBtnOrder().setOnClickListener(view -> {
                Bundle bundle = new Bundle();
                bundle.putSerializable("ticket", ticket);

                Intent intent = new Intent(this.context,UserDataActivity.class);
                intent.putExtras(bundle);
                this.context.startActivity(intent);

            ((Activity)this.context).finish();
        });

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    private void DrawableTickets(){
        List<Ticket> ticketsBundle = new ArrayList<>();

        ticketsBundle.add(localDataSet.get(0));
        localDataSet.forEach(ticket -> {
            ticketsBundle.forEach(t ->{
                if(ticket.getDeparture_time().equals(t.getDeparture_time())
                    && ticket.getArrival_time().equals(t.getArrival_time())){
                    t.setSeat(Integer.valueOf(t.getSeat())+1 +"");
                }
            });
        });

        localDataSet = ticketsBundle;

    }
}
