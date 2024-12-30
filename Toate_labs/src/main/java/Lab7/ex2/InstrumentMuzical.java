package Lab7.ex2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)


public  abstract class  InstrumentMuzical {
    private String producator;
    private String pret;

    public InstrumentMuzical(){}
    public InstrumentMuzical(String producator, String pret) {
        this.producator = producator;
        this.pret = pret;
    }

    public String getProducator() {
        return producator;
    }

    public String getPret() {
        return pret;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentMuzical that = (InstrumentMuzical) o;
        return Objects.equals(getProducator(), that.getProducator()) && Objects.equals(getPret(), that.getPret());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProducator(), getPret());
    }

    @Override
    public String toString() {
        return "InstrumentMuzical{" +
                "producator='" + producator + '\'' +
                ", pret='" + pret + '\'' +
                '}';
    }
}
