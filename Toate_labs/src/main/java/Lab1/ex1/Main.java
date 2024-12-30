package Lab1.ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("L1=");
        int l1=sc.nextInt();
        System.out.println("L2=");
        int l2=sc.nextInt();
        System.out.println("L3=");
        int l3=sc.nextInt();
        int sum=l1+l2+l3;
        System.out.println("Aria dreptunghiului="+l1*l2*l3+"\n"
                            +"Perimemtrul dreptunghiului="+sum);
    }
}
