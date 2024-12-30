package Lab2.ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new File("src/main/java/Lab2/ex2/cantec_in.txt"));

        ArrayList<String>versuri=new ArrayList<>();

        while(sc.hasNextLine()) {
            versuri.add(sc.nextLine());
        }
        sc.close();

        String[]v=versuri.toArray(new String[versuri.size()]);

        Scanner sc1=new Scanner(System.in);
        System.out.println("Grup de litere:");
        String grup=sc1.nextLine();
        sc1.close();


        FileWriter fw=new FileWriter("src/main/java/Lab2/ex2/cantec_out.txt");


        for(int i=0;i<v.length;i++) {


            int word=v[i].split(" ").length;
            int vocale=v[i].split("[aeiouAEIOU]").length;
            double random=Math.random();

            if(v[i].endsWith(grup)) {
                if(random<0.1) {
                    fw.write(v[i].toUpperCase() + " " + word + " " + vocale + " * ");
                    fw.write("\n");
                }
                else {
                    fw.write(v[i] + " " + word + " " + vocale + " * ");
                    fw.write("\n");
                }
            }
            else {
                if(random<0.1) {
                    fw.write(v[i].toUpperCase() + " " + word + " " + vocale);
                    fw.write("\n");
                }
                else {
                    fw.write(v[i] + " " + word + " " + vocale);
                    fw.write("\n");
                }
            }

        }
        fw.close();
    }
}
