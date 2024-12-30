package Lab4;

import java.io.Serializable;

public class echipamente  implements Serializable {
    private String denumire;
    private int nr_inv;
    private double pret;
    private zona zona_mag;
    private situatie situatie;

    public echipamente() {}
    public echipamente(String denumire,int nr_inv,double pret,zona zona_mag,situatie situatie) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.situatie = situatie;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
    public int getNr_inv() {
        return nr_inv;
    }

     public void setNr_inv(int nr_inv) {
         this.nr_inv = nr_inv;
     }

     public double getPret() {
         return pret;
     }

     public void setPret(double pret) {
        this.pret = pret;
     }

    public zona getZona_mag() {
        return zona_mag;
    }

    public situatie getSituatie() {
        return situatie;
    }

    public void setZona_mag(zona zona_mag) {
        this.zona_mag = zona_mag;
    }
    public void setSituatie(situatie situatie) {
        this.situatie = situatie;
    }

    @Override
     public String toString() {
        return "echipamente{" + "nume='" + denumire + '\'' + ", nr_inv=" + nr_inv + ", pret=" + pret + ", zona_mag='" + zona_mag + '\'' + ", situatie='" + situatie + '\'' + '}';
    }



}
