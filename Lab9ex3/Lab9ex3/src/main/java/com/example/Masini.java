package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="masini_DataJPA")
public class Masini {
    @Id
    private String nrinmatriculare;
    private String marca;
    private int anulfabricatiei;
    private String culoare;
    private int nrkm;

    public Masini() {}
    public Masini(String nr_inmatriculare, String marca, int anul_fabricatiei, String culoare, int nr_km) {
        this.nrinmatriculare = nr_inmatriculare;
        this.marca = marca;
        this.anulfabricatiei = anul_fabricatiei;
        this.culoare = culoare;
        this.nrkm = nr_km;
    }

    public String getNrInmatriculare() {
        return nrinmatriculare;
    }

    public void setNr_inmatriculare(String nr_inmatriculare) {
        this.nrinmatriculare = nr_inmatriculare;
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
        return anulfabricatiei;
    }

    public void setAnul_fabricatiei(int anul_fabricatiei) {
        this.anulfabricatiei = anul_fabricatiei;
    }

    public long getNr_Km() {
        return nrkm;
    }

    public void setNr_km(int nr_km) {
        this.nrkm = nr_km;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "nr_inmatriculare='" + nrinmatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", anul_fabricatiei=" + anulfabricatiei +
                ", culoare='" + culoare + '\'' +
                ", nr_km=" + nrkm +
                '}';
    }

}
