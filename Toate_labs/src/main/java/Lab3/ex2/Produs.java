package Lab3.ex2;

import java.time.LocalDate;

public class Produs {
    private  String denumire;
    private double pret;
    private  int cantitate;
    private  LocalDate data;
    public  static double incasari=0;

    public Produs(String denumire, double pret, int cantitate, LocalDate data) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data = data;
    }

    public String getDenumire() {
        return denumire;
    }
    public double getPret() {
        return pret;
    }
    public int getCantitate() {
        return cantitate;
    }
    public LocalDate getData() {
        return data;
    }

    public  double getIncasari() {
        return incasari;
    }

   public void setDenumire(String denumire) {
        this.denumire = denumire;
   }
   public void setPret(double pret) {
        this.pret = pret;
   }
   public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
   }
   public void setData(LocalDate data) {
        this.data = data;
   }

   @Override
    public String toString() {
        return denumire + "\t" + pret + "\t" + cantitate + "\t" + data;
   }

}
