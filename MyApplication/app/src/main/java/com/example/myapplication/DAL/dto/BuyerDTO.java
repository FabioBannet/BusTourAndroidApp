package com.example.myapplication.DAL.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BuyerDTO {
    @SerializedName("fio")
    @Expose
    private String fio;
    @SerializedName("mobile_number")
    @Expose
    private String mobile_number;

    public BuyerDTO() {}

    public BuyerDTO(String fio, String mobile_number) {
        this.fio = fio;
        this.mobile_number = mobile_number;
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
}

