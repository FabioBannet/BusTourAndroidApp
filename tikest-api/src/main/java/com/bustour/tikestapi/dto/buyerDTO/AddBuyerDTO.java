package com.bustour.tikestapi.dto.buyerDTO;

public class AddBuyerDTO {
    private String fio;
    private String mobile_number;

    public AddBuyerDTO() {}

    public AddBuyerDTO(String fio, String mobile_number) {
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

