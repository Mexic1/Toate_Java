package Lab4;

import java.io.Serializable;

public class sistem_calcul extends echipamente implements Serializable {
    private String tip_mon;
    private double viteza;
    private int c_hdd;
    private sistem sistem;

    public sistem_calcul(String denumire,int nr_inv,double pret,zona zona_mag,situatie situatie,String tip_mon, double viteza, int c_hdd, sistem sistem) {
        super( denumire, nr_inv, pret, zona_mag, situatie);
        this.tip_mon = tip_mon;
        this.viteza = viteza;
        this.c_hdd = c_hdd;
        this.sistem = sistem;
    }

    public String getTip_mon() {
        return tip_mon;
    }
    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }

    public double getViteza() {
        return viteza;
    }

    public void setViteza(double viteza) {
        this.viteza = viteza;
    }

    public int getc_hdd() {
        return c_hdd;
    }

    public void setc_hdd(int c_hdd) {
        this.c_hdd = c_hdd;
    }

    public sistem getSistem() {
        return sistem;
    }

    public void setSistem(sistem sistem) {
        this.sistem = sistem;
    }

    @Override
    public String toString() {
        return super.toString()+"tip_mon='" + tip_mon + '\'' + ", vit_proc=" + viteza + ", c_hdd=" + c_hdd + ", sys_op='" + sistem;
    }
}
