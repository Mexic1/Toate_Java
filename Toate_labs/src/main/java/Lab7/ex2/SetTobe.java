package Lab7.ex2;

public class SetTobe extends InstrumentMuzical{
    private Tiptobe tiptobe;
    private int nrTobe;
    private int nr_cinele;

    public SetTobe(){}
    public SetTobe(String producator, String pret, Tiptobe tiptobe, int nrTobe, int nr_cinele) {
        super(producator, pret);
        this.tiptobe = tiptobe;
        this.nrTobe = nrTobe;
        this.nr_cinele = nr_cinele;
    }

    public Tiptobe getTiptobe() {
        return tiptobe;
    }

    public int getNr_cinele() {
        return nr_cinele;
    }

    public int getNrTobe() {
        return nrTobe;
    }

    public void setTiptobe(Tiptobe tiptobe) {
        this.tiptobe = tiptobe;
    }

    public void setNr_cinele(int nr_cinele) {
        this.nr_cinele = nr_cinele;
    }

    public void setNrTobe(int nrTobe) {
        this.nrTobe = nrTobe;
    }

    @Override
    public String toString() {
        return super.toString()+ "SetTobe{" +
                "tiptobe=" + tiptobe +
                ", nrTobe=" + nrTobe +
                ", nr_cinele=" + nr_cinele +
                '}';
    }
}
