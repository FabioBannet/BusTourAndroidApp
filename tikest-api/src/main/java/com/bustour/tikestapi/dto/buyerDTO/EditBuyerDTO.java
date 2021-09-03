package com.bustour.tikestapi.dto.buyerDTO;

public class EditBuyerDTO {
    private Integer id;

    private String fio;
    private String mobile_number;

    public EditBuyerDTO() {}

    public EditBuyerDTO(Integer id, String fio, String mobile_number) {
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
}
