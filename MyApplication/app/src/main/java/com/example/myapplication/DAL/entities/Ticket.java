package com.example.myapplication.DAL.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class Ticket implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("direction")
    @Expose
    private String direction;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("departure_time")
    @Expose
    private String departure_time;

    @SerializedName("arrival_time")
    @Expose
    private String arrival_time;

    @SerializedName("seat")
    @Expose
    private String seat;

    @SerializedName("price")
    @Expose
    private Double price;

    @SerializedName("buyer")
    @Expose
    private Buyer buyer;


    public Ticket() {}

    public Ticket(Integer id, String direction, String date, String departure_time, String arrival_time, String seat, Double price, Buyer buyer) {
        this.id = id;
        this.direction = direction;
        this.date = date;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.seat = seat;
        this.price = price;
        this.buyer = buyer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return price == ticket.price && Objects.equals(id, ticket.id) && Objects.equals(direction, ticket.direction) && Objects.equals(date, ticket.date) && Objects.equals(departure_time, ticket.departure_time) && Objects.equals(arrival_time, ticket.arrival_time) && Objects.equals(seat, ticket.seat) && Objects.equals(buyer, ticket.buyer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, direction, date, departure_time, arrival_time, seat, price, buyer);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", direction='" + direction + '\'' +
                ", data='" + date + '\'' +
                ", departure_time='" + departure_time + '\'' +
                ", arrival_time='" + arrival_time + '\'' +
                ", seat='" + seat + '\'' +
                ", price=" + price +
                ", buyer=" + buyer +
                '}';
    }
}
