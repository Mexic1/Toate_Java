package Lab5.ex2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
//import com.sun.org.apache.xalan.internal.lib.ExsltSets;

// static com.sun.org.apache.xalan.internal.lib.ExsltSets.distinct;

public class Main {
    public static void scriere(List<Mobilier> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            File file=new File("src/main/resources/Lab5ex2/mobilier.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Mobilier> citire() {
        try {
            File file=new File("src/main/resources/Lab5ex2/mobilier.json");
            ObjectMapper mapper=new ObjectMapper();
            List<Mobilier> persoane = mapper
                    .readValue(file, new TypeReference<List<Mobilier>>(){});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {

        List<Placi> p=new ArrayList<>();
        p.add(new Placi("placa1",200,60,Orientare.LUNGIME,new boolean[]{true,true,true,true},70));
        p.add(new Placi("placa2",220,150,Orientare.LATIME,new boolean[]{true,true,false,true},500));
        p.add(new Placi("placa3",250,100,Orientare.LUNGIME,new boolean[]{true,true,true,true},170));
        List<Mobilier> m=new ArrayList<>();
        m.add(new Mobilier("mobilier1",p));
        m.add(new Mobilier("mobilier2",p));
        scriere(m);

       List<Mobilier>mobila=citire();
        mobila.forEach(System.out::println);

        System.out.println("\n");
        mobila.get(0).getPlaca().forEach(System.out::println);


        int aria=2800*2070;
        int nrColi=0;
        for(Mobilier mob:mobila){
            for(Placi pl:mob.getPlaca()){
                int ariePlaca=pl.getLungime()*pl.getLatime();
                nrColi+=ariePlaca*pl.getNr_bucati()/aria;
            }
        }
        System.out.println("Nr coli necesare: "+nrColi);
    }
}
