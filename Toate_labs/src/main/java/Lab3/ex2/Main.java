package Lab3.ex2;

import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("src/main//java/Lab3/ex2/produse.csv"));

        List<Produs> produse=new ArrayList<Produs>();

        while (sc.hasNextLine()) {
            String line=sc.nextLine();
            String[] parts=line.split("\\s*,\\s*");
            Produs p=new Produs(parts[0],Double.parseDouble(parts[1]), Integer.parseInt(parts[2]),LocalDate.parse(parts[3]));
            produse.add(p);
        }
        sc.close();

        while(true)
        {
            Scanner sc2 = new Scanner(System.in);
            System.out.println("1.Afisare produse");
            System.out.println("2.Afisare produse expirate");
            System.out.println("3.Vanzare produs");
            System.out.println("4.Afisare Pret minim");
            System.out.println("5.Salvare in fisier");
            System.out.println("0.Iesire");
            int option=sc2.nextInt();

            switch(option) {
                case 1: afisare(produse);
                    System.out.println("\n");
                    break;
                case 2: afisexp(produse);
                    break;
                case 3:
                    System.out.println("Produs dorit:");
                    String nume=sc2.next();

                    System.out.println("Cantitate dorita:");
                    int cant=sc2.nextInt();

                    vanzare(produse,cant,nume);
                    System.out.println("\n");
                    break;
                case 4: pret_minim(produse);
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("Cantitate:");
                    int canti=sc2.nextInt();
                    salvare(produse,canti);
                    System.out.println("\n");
                    break;
                case 0: return;
                default:
                    System.out.println("Optiunea nu exista");
                    break;
            }
        }

    }

    public static void afisare(List<Produs> produse)
    {
        for(Produs p:produse){
            System.out.println(p);
        }
    }

    public static  void afisexp(List<Produs> produse)
    {
        for(Produs p:produse){
            LocalDate acum=LocalDate.now();
            if(acum.isAfter(p.getData()))
            {
                System.out.println(p);
            }
        }
    }

    public static void vanzare(List<Produs> produse,int cant,String nume)
    {
        int i=0;
        for(Produs p:produse){
            i++;
            if(Objects.equals(p.getDenumire(), nume))
            {

                if(p.getCantitate()>=cant)
                {
                    p.setCantitate(p.getCantitate()-cant);
                    Produs.incasari+=cant*p.getPret();
                    System.out.println("Vanzare reusita"+Produs.incasari);
                    break;
                }
                else {
                    Produs.incasari+=p.getPret()*p.getCantitate();
                    System.out.println("Vanzare nereusita");
                    produse.remove(i-1);
                    break;
                }
            }
        }

    }

    public  static void pret_minim(List<Produs> produse)
    {
        double min=produse.get(0).getPret();
        System.out.println(min);
        for(Produs p:produse){
            if(p.getPret()<min) min=p.getPret();
        }
        for (Produs p : produse) {
            if(p.getPret()==min) System.out.println(p);
        }
    }

    public static void salvare(List<Produs> produse,int canti) {

        try {
            PrintWriter writer = new PrintWriter(new File("src/main//java/Lab3/ex2/produseout.csv"));

            for (Produs p : produse) {
                if (p.getCantitate() < canti) writer.println(p);
                System.out.println(p);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("A apărut o eroare: " + e.getMessage());
            return;
        }
    }
}















