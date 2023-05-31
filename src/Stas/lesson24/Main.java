package Stas.lesson24;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the starting number M: ");
        int M = scan.nextInt();

        System.out.print("Enter the ending number N: ");
        int N = scan.nextInt();

        System.out.print("Enter the number of divisors: ");
        int numDivisors = scan.nextInt();

        System.out.print("Enter the divisors: ");
        int[] divisors = new int[numDivisors];
        for (int i = 0; i < numDivisors; i++) {
            divisors[i] = scan.nextInt();
        }
        for (int divisor : divisors) {
            int sum = 0;
            for (int num = M; num <= N; num++) {
                if (num % divisor == 0) {
                    sum += num;
                }
            }
            System.out.println("Sum for divisor " + divisor + ": " + sum);
        }
    }
}
