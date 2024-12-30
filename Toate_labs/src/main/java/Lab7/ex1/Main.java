package Lab7.ex1;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.w3c.dom.ls.LSOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void scriere(Map<Integer,Carte> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            File file=new File("src/main/resources/Lab7ex1/Carte.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<Integer,Carte> citire() {
        try {
            File file=new File("src/main/resources/Lab7ex1/Carte.json");
            ObjectMapper mapper=new ObjectMapper();
            Map<Integer,Carte> persoane = mapper
                    .readValue(file, new TypeReference<Map<Integer,Carte>>(){});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        Map<Integer,Carte> map=new HashMap<Integer,Carte>();

        map.put(1,new Carte("Homo Deus: A Brief History of Tomorrow","Yuval Noah Harari",2015));
        map.put(2,new Carte("To Kill a Mockingbird","Harper Lee",2018));
        map.put(3,new Carte("Brave New World","Aldous Huxley",2011));
        map.put(4,new Carte("Homo Deus: A Brief History of Tomorrow","Paulo Coelho",2013));
        map.put(5,new Carte("The Alchemist","Paulo Coelho",2020));

        scriere(map);


        map=citire();
        map.forEach((id,carte)->System.out.println(id+" "+carte));

        Set<Carte> s=new HashSet<>();

        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("0.Iesire");
            System.out.println("1.Sa se stearga o carte din colectia map");
            System.out.println("2. Adaugam o carte");
            System.out.println("3. Salveaza in fisier modificarile");
            System.out.println("4. Salvea in Set");
            System.out.println("5. Ordoneaza Set-ul dupa titlu");
            System.out.println("6. Datele celei mai vechi carti");
            System.out.println("Optiunea dorita:");
            int opt=sc.nextInt();
            switch(opt) {
                case 0:
                    sc.close();
                    return;
                case 1:
                    System.out.println("Alegeti cartea pe care vreti sa o stergeti:");
                    int id1=sc.nextInt();
                    map.remove(id1);
                        map.forEach((id,carte)-> System.out.println(id+" "+carte));
                    break;
                    case 2:
                        System.out.println("Titlu carte:");
                        String titlu=sc.next();
                        System.out.println("Autor:");
                        String autor=sc.next();
                        System.out.println("Anul aparitiei:");
                        int anul=sc.nextInt();

                        int max=Collections.max(map.keySet());
                        map.putIfAbsent(max,new Carte(titlu,autor,anul));
                        break;
                case 3:scriere(map);
                    break;
                case 4:
                     s=map.values().stream()
                        .filter(a->a.getAutor().equals("Yuval Noah Harari"))
                        .collect(Collectors.toSet());
                    s.forEach(System.out::println);
                    break;
                case 5:
                    s.stream()
                            .sorted(Comparator.comparing(Carte::getTitlu))
                            .forEach(System.out::println);
                    break;
                case 6:
                    s.stream()
                            .min(Comparator.comparing(Carte::getAn))
                            .ifPresent(System.out::println);
                    break;
                default:
                    System.out.println("Optiunea nu exista");
                    break;
            }
        }

    }
}