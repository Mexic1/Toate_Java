package Lab4;

import java.io.Serializable;

public class Imprimante extends echipamente implements Serializable {
    private int ppm;
    private String dpi;
    private int p_car;
    private tiparire tiparire;

    public Imprimante(String denumire,int nr_inv,double pret,zona zona_mag,situatie situatie,int ppm, String dpi, int p_car, tiparire t){
        super(denumire,nr_inv,pret,zona_mag,situatie);
        this.ppm = ppm;
        this.dpi = dpi;
        this.p_car = p_car;
        this.tiparire = t;
    }

    public int getPpm() {
        return ppm;
    }
    public void setPpm(int ppm) {
        this.ppm = ppm;
    }
    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public int getP_car() {
        return p_car;
    }
    public void setP_car(int p_car) {
        this.p_car = p_car;
    }
    public tiparire getTiparire() {
        return tiparire;
    }
    public void setTiparire(tiparire tiparire) {
        this.tiparire = tiparire;
    }

    @Override
    public String toString(){
        return super.toString()+"ppm=" + ppm + ", rezolutie='" + dpi + '\'' + ", p_cat=" + p_car + ", color='" + tiparire;
    }

}
