package com.bustour.tikestapi.dto.ticketDTO;

public class EditTicketDTO {
    private Integer id;
    private String direction;
    private String date;
    private String departure_time;
    private String arrival_time;
    private String seat;
    private Double price;

    private Integer buyer_id;

    public EditTicketDTO() {}

    public EditTicketDTO(Integer id, String direction, String date, String departure_time, String arrival_time, String seat, Double price, Integer buyer_id) {
        this.id = id;
        this.direction = direction;
        this.date = date;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.seat = seat;
        this.price = price;
        this.buyer_id = buyer_id;
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

    public Integer getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Integer buyer_id) {
        this.buyer_id = buyer_id;
    }
}
