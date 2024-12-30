package com.example.Laboratorul10;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;


@Getter
@Entity
@Table(name="carti")
public class Carte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String Titlul;

    private String Autorul;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getAutorul() {
        return Autorul;
    }

    public void setAutorul(String autorul) {
        Autorul = autorul;
    }

    public String getTitlul() {
        return Titlul;
    }

    public void setTitlul(String titlul) {
        Titlul = titlul;
    }

    public Carte() {}
    public Carte(String titlul, String autorul) {
        this.Titlul = titlul;
        this.Autorul = autorul;
    }


    @Override
    public String toString() {
        return "Carte{" +
                "Id=" + Id +
                ", Titlul='" + Titlul + '\'' +
                ", Autorul='" + Autorul + '\'' +
                '}';
    }
}
