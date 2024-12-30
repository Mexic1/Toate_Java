package Lab7.ex1;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS    // Use the class name as the type ID
       // include = JsonTypeInfo.As.PROPERTY, // Include it as a property in the JSON
       // property = "@class"             // The property name in the JSON
)

public class Carte {
    private String titlu;
    private String autor;
    private int an;

    public Carte() {}
    public Carte(String titlu, String autor, int an) {
        this.titlu = titlu;
        this.an = an;
        this.autor = autor;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public int getAn() {
        return an;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                ", an=" + an +
                '}';
    }
}
