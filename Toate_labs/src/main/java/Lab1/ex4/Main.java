package Lab1.ex4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int num1 = random.nextInt(31); // Generates a random number between 0 and 30
        int num2 = random.nextInt(31); // Generates a random number between 0 and 30

        System.out.println("Generated numbers: " + num1 + ", " + num2);
        System.out.println("GCD: " + gcd(num1, num2));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}