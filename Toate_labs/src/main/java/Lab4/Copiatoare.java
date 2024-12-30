package Lab4;

import java.io.Serializable;

public class Copiatoare extends echipamente implements Serializable {
    private int p_ton;
    private format format;

    public Copiatoare(String denumire,int nr_inv,double pret,zona zona_mag,situatie situatie,int p_ton, format format) {
        super( denumire, nr_inv, pret, zona_mag, situatie);
        this.p_ton = p_ton;
        this.format = format;
    }

    public int getP_ton() {
        return p_ton;
    }

    public void setP_ton(int p_ton) {
        this.p_ton = p_ton;
    }

    public format getFormat() {
        return format;
    }

    public void setFormat(format format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString()+"Copiatoare [p_ton=" + p_ton + ", format=" + format + "]";
    }
}
