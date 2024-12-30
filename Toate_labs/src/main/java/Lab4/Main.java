package Lab4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("src/main/java/Lab4/echipamente.txt"));

        List<echipamente> echip=new ArrayList<echipamente>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] items = line.split(";");
           // System.out.println(items[5]);
            if(Objects.equals(items[5], "imprimanta"))
            {
                echip.add(new Imprimante(items[0], Integer.parseInt(items[1]),Integer.parseInt(items[2]),zona.valueOf(items[3]),situatie.valueOf(items[4]),Integer.parseInt(items[6]),items[7],Integer.parseInt(items[8]),tiparire.valueOf(items[9])));
            }

            if(items[5].equals("copiator"))
            {
                echip.add(new Copiatoare(items[0], Integer.parseInt(items[1]),Double.parseDouble(items[2]),zona.valueOf(items[3]),situatie.valueOf(items[4]), Integer.parseInt(items[6]),format.valueOf(items[7])));
            }

            if(Objects.equals(items[5], "sistem de calcul"))
            {
                echip.add(new sistem_calcul(items[0], Integer.parseInt(items[1]),Integer.parseInt(items[2]),zona.valueOf(items[3]),situatie.valueOf(items[4]),items[6],Double.parseDouble(items[7]),Integer.parseInt(items[8]),sistem.valueOf(items[9])));
            }

        }
        sc.close();


        Scanner sc1=new Scanner(System.in);

        while(true)
        {
            System.out.println("\n");
            System.out.println("1. Afisarea tuturor echipamentelor");
            System.out.println("2. Afisarea imprimantelor");
            System.out.println("3. Afisarea copiatoarelor");
            System.out.println("4. Afisarea sistemelor de calcul");
            System.out.println("5. Modificarea starii in care se afla un obiect");
            System.out.println("6. Setarea unui anumit mod de scriere pentru o imprimanta");
            System.out.println("7. Setarea unui format de copiere pentru copiatoare");
            System.out.println("8. Instalarea unui anumit sistem de operare pe un sistem de calcul ");
            System.out.println("9. Afişarea echipamentelor vândute ");
            System.out.println("10.Să se realizeze două metode statice pentru serializarea / deserializarea colecției de\n" +
                    "obiecte în fișierul echip.bin  ");
            System.out.println("0. Iesire");
            System.out.println("Introduceti optiunea dorita: ");
            int optiune;
            optiune = sc1.nextInt();

            switch(optiune) {
                case 0:
                    return;
                case 1: for(echipamente e:echip) {System.out.println(e);}
                    break;
                case 2:for(echipamente e:echip) {if(e instanceof Imprimante) {System.out.println(e);}}
                    break;
                case 3:for(echipamente e:echip) {if(e instanceof Copiatoare) {System.out.println(e);}}
                    break;
                case 4:for(echipamente e:echip) {if(e instanceof sistem_calcul) {System.out.println(e);}}
                    break;
                case 5:
                    System.out.println("Nume:");
                   String nume= sc1.next();
                   System.out.println("Situatie");
                   String sit= sc1.next();
                   modificare(echip,nume,sit);
                    break;
                case 6:
                    System.out.println("Nume:");
                    String nume_imp= sc1.next();
                    System.out.println("Situatie");
                    String mod= sc1.next();
                    set_mod(echip,nume_imp,mod);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:afis_vandut(echip);
                    break;
                case 10:
                    System.out.println("1.Serializare / 2.Deserializare");
                    int opt= sc1.nextInt();
                    if(opt == 1)
                    {
                        serializare(echip);
                    }
                    else if(opt == 2)
                    {
                        List<echipamente> q;
                        q = (List<echipamente>) citeste();
                        for (echipamente p : q)
                            System.out.println(p);
                    }
                    break;
                    default: System.out.println("Optiunea nu exista");
                        break;
            }
        }

    }

    public static void modificare(List<echipamente>echip,String nume,String sit)
    {
            for(echipamente e:echip)
            {
                if(e.getDenumire().equals(nume)) e.setSituatie(situatie.valueOf(sit));
            }
    }

    public static void set_mod(List<echipamente>echip,String nume,String mod)
    {
        for(echipamente e:echip)
        {
            if(e.getDenumire().equals(nume) && e instanceof Imprimante) ((Imprimante) e).setTiparire(tiparire.valueOf(mod));
        }
    }

    public static void afis_vandut(List<echipamente>echip)
    {
        for(echipamente e:echip)
        {
            if(e.getSituatie()==situatie.valueOf("vandut")){System.out.println(e);}
        }
    }

    public static void serializare(List<echipamente> o)  {
        try {
            FileOutputStream f = new FileOutputStream("src/main/java/Lab4/echip.bin");
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Object citeste() {
        try {
            FileInputStream f = new FileInputStream("src/main/java/Lab4/echip.bin");
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}