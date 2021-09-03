package com.example.myapplication.DAL.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Buyer {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("fio")
    @Expose
    private String fio;

    @SerializedName("mobile_number")
    @Expose
    private String mobile_number;

    public Buyer() {}

    public Buyer(Integer id, String fio, String mobile_number) {
        this.id = id;
        this.fio = fio;
        this.mobile_number = mobile_number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(id, buyer.id) && Objects.equals(fio, buyer.fio) && Objects.equals(mobile_number, buyer.mobile_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, mobile_number);
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", FIO='" + fio + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                '}';
    }
}
