package Lab5.ex2;

import java.util.Arrays;
import java.util.Objects;

public class Placi {
    private String descriere;
    private int lungime;
    private int latime;
    private Orientare orientare;
    private boolean[] canturi;
    private int nr_bucati;


    public Placi() {}

    public Placi(String descriere, int lungime, int latime, Orientare orientare, boolean[] canturi, int nr_bucati) {
        this.descriere = descriere;
        this.lungime = lungime;
        this.latime = latime;
        this.orientare = orientare;
        this.canturi = canturi;
        this.nr_bucati = nr_bucati;
    }

    public String getDescriere() {
        return descriere;
    }

    public int getLungime() {
        return lungime;
    }

    public int getLatime() {
        return latime;
    }

    public Orientare getOrientare() {
        return orientare;
    }

    public boolean[] getCanturi() {
        return canturi;
    }

    public int getNr_bucati() {
        return nr_bucati;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setNr_bucati(int nr_bucati) {
        this.nr_bucati = nr_bucati;
    }

    public void setCanturi(boolean[] canturi) {
        this.canturi = canturi;
    }

    public void setOrientare(Orientare orientare) {
        this.orientare = orientare;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Placi placi = (Placi) o;
        return getLungime() == placi.getLungime() && getLatime() == placi.getLatime() && getNr_bucati() == placi.getNr_bucati() && Objects.equals(getDescriere(), placi.getDescriere()) && getOrientare() == placi.getOrientare() && Objects.deepEquals(getCanturi(), placi.getCanturi());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescriere(), getLungime(), getLatime(), getOrientare(), Arrays.hashCode(getCanturi()), getNr_bucati());
    }

    @Override
    public String toString() {
        return "Placi{" +
                "descriere='" + descriere + '\'' +
                ", lungime=" + lungime +
                ", latime=" + latime +
                ", orientare=" + orientare +
                ", canturi=" + Arrays.toString(canturi) +
                ", nr_bucati=" + nr_bucati +
                '}';
    }
}

