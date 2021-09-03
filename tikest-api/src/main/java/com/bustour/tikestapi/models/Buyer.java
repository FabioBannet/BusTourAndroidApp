package com.bustour.tikestapi.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fio;
    private String mobile_number;

    public Buyer() {}

    public Buyer(Integer id, String FIO, String mobile_number) {
        this.id = id;
        this.fio = FIO;
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
        return "buyer{" +
                "id=" + id +
                ", FIO='" + fio + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                '}';
    }
}
