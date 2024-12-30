package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="masiniJPA")
public class Masini {
    @Id
    private String nr_inmatriculare;
    private String marca;
    private int anul_fabricatiei;
    private String culoare;
    private long nr_km;

    public Masini() {}
    public Masini(String nr_inmatriculare, String marca, int anul_fabricatiei, String culoare, long nr_km) {
        this.nr_inmatriculare = nr_inmatriculare;
        this.marca = marca;
        this.anul_fabricatiei = anul_fabricatiei;
        this.culoare = culoare;
        this.nr_km = nr_km;
    }

    public String getNrInmatriculare() {
        return nr_inmatriculare;
    }

    public void setNr_inmatriculare(String nr_inmatriculare) {
        this.nr_inmatriculare = nr_inmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getAnulFabricatiei() {
        return anul_fabricatiei;
    }

    public void setAnul_fabricatiei(int anul_fabricatiei) {
        this.anul_fabricatiei = anul_fabricatiei;
    }

    public long getNrKm() {
        return nr_km;
    }

    public void setNr_km(long nr_km) {
        this.nr_km = nr_km;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "nr_inmatriculare='" + nr_inmatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", anul_fabricatiei=" + anul_fabricatiei +
                ", culoare='" + culoare + '\'' +
                ", nr_km=" + nr_km +
                '}';
    }

}
