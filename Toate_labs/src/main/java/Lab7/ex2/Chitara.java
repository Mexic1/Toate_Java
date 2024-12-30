package Lab7.ex2;

public class Chitara extends InstrumentMuzical{
    private Tipchitara tipChitara;
    private int numarCorzi;

    public Chitara(){}
    public Chitara(String producator, String pret, Tipchitara tipChitara, int numarCorzi) {
        super(producator, pret);
        this.tipChitara = tipChitara;
        this.numarCorzi = numarCorzi;
    }

    public Tipchitara getTipChitara() {
        return tipChitara;
    }

    public int getNumarCorzi() {
        return numarCorzi;
    }

    public void setTipChitara(Tipchitara tipChitara) {
        this.tipChitara = tipChitara;
    }

    public void setNumarCorzi(int numarCorzi) {
        this.numarCorzi = numarCorzi;
    }

    @Override
    public String toString() {
        return super.toString()+ "Chitara{" +
                "tipChitara=" + tipChitara +
                ", numarCorzi=" + numarCorzi +
                '}';
    }
}
