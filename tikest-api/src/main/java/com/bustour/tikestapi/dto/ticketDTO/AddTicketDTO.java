package com.bustour.tikestapi.dto.ticketDTO;

public class AddTicketDTO {
    private String direction;
    private String data;
    private String departure_time;
    private String arrival_time;
    private String seat;
    private Double price;
    private Integer buyer_id;

    public AddTicketDTO() {}

    public AddTicketDTO(String direction, String data, String departure_time, String arrival_time, String seat, Double price, Integer buyer_id) {
        this.direction = direction;
        this.data = data;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.seat = seat;
        this.price = price;
        this.buyer_id = buyer_id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
