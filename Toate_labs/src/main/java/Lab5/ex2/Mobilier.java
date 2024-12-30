package Lab5.ex2;

import java.util.List;
import java.util.Objects;

public class Mobilier {
    private String nume;
    private List<Placi> placi;

    public Mobilier() {}

    public Mobilier(String nume, List<Placi> placi) {
        this.nume = nume;
        this.placi = placi;
    }

    public String getNume() {
        return nume;
    }

    public List<Placi> getPlaca() {
        return placi;
    }


    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPlaca(List<Placi> placi) {
        this.placi = placi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mobilier mobilier = (Mobilier) o;
        return Objects.equals(getNume(), mobilier.getNume()) && Objects.equals(placi, mobilier.placi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNume(), placi);
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "nume='" + nume + '\'' +
                ", placa=" + placi +
                '}';
    }
}
