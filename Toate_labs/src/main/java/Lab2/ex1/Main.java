package Lab2.ex1;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/main/java/Lab2/ex1/judete_in.txt"));
        ArrayList<String> judete = new ArrayList<>();

        while(sc.hasNext())
        {
           judete.add(sc.next());
        }
        sc.close();

        for(int i = 0; i < judete.size(); i++)
        {
            System.out.println(judete.get(i));
        }

        String[] j= judete.toArray(new String[judete.size()]);
        Arrays.sort(j);

        System.out.println("\n");
        for(int i = 0; i < j.length; i++)
        {
            System.out.println(j[i]);
        }

        System.out.println("Introduceti judet:");

        Scanner sc1=new Scanner(System.in);
        String judet=sc1.nextLine();

        int poz= Arrays.binarySearch(j,judet);
        System.out.println(poz);


    }


}
