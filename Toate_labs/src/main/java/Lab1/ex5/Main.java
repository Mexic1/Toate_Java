package Lab1.ex5;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int num = random.nextInt(21);

        System.out.println("Generated number: " + num);
        if (isFibonacci(num)) {
            System.out.println("The number " + num + " is a Fibonacci number.");
        } else {
            System.out.println("The number " + num + " is not a Fibonacci number.");
        }
    }

    public static boolean isFibonacci(int n) {
        if (n == 0 || n == 1) {
            return true;
        }
        int a = 0, b = 1;
        while (b < n) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b == n;
    }
}