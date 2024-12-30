package com.example.Laboratorul11.Entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Entity
@Table(name = "evenimente")
public class Evenimente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denumire;
    private String locatie;
    private LocalDate data;
    private LocalTime timp;
    private Float pret;

    public Evenimente() {}

    public Evenimente(Long id, String denumire, String locatie, LocalDate data, LocalTime timp, Float pret) {
        this.id = id;
        this.denumire = denumire;
        this.locatie = locatie;
        this.data = data;
        this.timp = timp;
        this.pret = pret;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setTimp(LocalTime timp) {
        this.timp = timp;
    }

    public void setPret(Float pret) {
        this.pret = pret;
    }

    public Long getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getLocatie() {
        return locatie;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getTimp() {
        return timp;
    }

    public Float getPret() {
        return pret;
    }

    @Override
    public String toString() {
        return "Evenimente{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", locatie='" + locatie + '\'' +
                ", data=" + data +
                ", timp=" + timp +
                ", pret=" + pret +
                '}';
    }
}
