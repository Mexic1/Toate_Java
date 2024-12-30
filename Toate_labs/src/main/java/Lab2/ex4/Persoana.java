package Lab2.ex4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Per{
    String name;
    String cnp;
    Per(String name,String cnp)
    {
        this.name=name;
        this.cnp=cnp;
    }

    public String getName()
    {
        return name;
    }

    public String getCnp()
    {
        return cnp;
    }

    public String getVarsta()
    {
        int yearPrefix = (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') ? 1900 : 2000;
        int birthYear = yearPrefix + Integer.parseInt(cnp.substring(1, 3));
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int varsta = currentYear - birthYear;
        return String.valueOf(varsta);
    }
}

public class Persoana {

    public static void main(String[] args) {

        //citim nr persoane
        Scanner sc=new Scanner(System.in);
        System.out.println("Nr persoane:");
        int n=sc.nextInt();

        String nume,cnp="0";
        ArrayList<Per>lista=new ArrayList<>();

        //citim persoanele
        for(int i=1;i<=n;i++)
        {
            nume=sc.next();
            int c=0;

            while(c!=1) //cat timp nu s-a introdus un CNP valid
            {
                cnp=sc.next();

                if(cnp.length()!=13)
                {
                    System.out.println("CNP-ul trebuie sa aiba 13 caractere");
                }
                else if(cnp.split("(?<=.)").length!=13)
                {
                    System.out.println("CNP-ul trebuie sa contina doar cifre");
                }
                else if(cnp.charAt(0)=='1' || cnp.charAt(0)=='2' || cnp.charAt(0)=='5'|| cnp.charAt(0)=='6')
                {
                    int re=(cnp.charAt(0) * 2 + cnp.charAt(1) * 7 + cnp.charAt(2) * 9 + cnp.charAt(3) + cnp.charAt(4) * 4 + cnp.charAt(5) * 6 + cnp.charAt(6) * 3 + cnp.charAt(7) * 5 + cnp.charAt(8) * 8 + cnp.charAt(9) * 2 + cnp.charAt(10) * 7 + cnp.charAt(11) * 9) % 11;

                    if(re==cnp.charAt(12)) c=1;

                    else if (re==10 && cnp.charAt(12)=='0')
                    {
                        c=1;
                    }
                    else
                    {
                        System.out.println("CNP-ul nu este valid");
                    }
                }
                else System.out.println("CNP-ul trebuie sa inceapa cu 1, 2, 5 sau 6");
            }
            Per om=new Per(nume,cnp);
            lista.add(om);
        }

        for(Per i:lista)
        {
            System.out.println("Nume: "+i.getName()+"  CNP: "+i.getCnp()+" Varsta:  "+i.getVarsta()+"\n");
        }


    }
}

