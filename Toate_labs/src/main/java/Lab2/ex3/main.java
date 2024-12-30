package Lab2.ex3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Sir original:");
        String val=sc.nextLine();
        StringBuilder x = new StringBuilder(val);

        System.out.println("Sir de introdus:");
        String y = sc.nextLine();

        System.out.println("Pozitie de introdus:");
        int poz=sc.nextInt();
        System.out.println(x.substring(0,poz)+y+x.substring(poz));

        System.out.println("Numar caractere");
        int nr=sc.nextInt();
        System.out.println(x.substring(0,poz)+x.substring(nr+poz));

        sc.close();

    }
}
