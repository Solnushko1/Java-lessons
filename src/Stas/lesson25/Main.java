
package Stas.lesson25;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the starting number M: ");
        int M = scan.nextInt();
        System.out.print("Enter the ending number N: ");
        int N = scan.nextInt();
        int[] divisors = null;
        if (args.length >= 2) {
            divisors = new int[args.length - 2];
            for (int i = 0; i < divisors.length; i++) {
                divisors[i] = scan.nextInt();
            }
        }
        int sum = 0;
        for (int j = M; j <= N; j++) {
            boolean isDivisible = true;
            if (divisors != null) {
                for (int divisor : divisors) {
                    if (j % divisor != 0) {
                        isDivisible = false;
                        break;
                    }
                }
            }
            if (isDivisible) {
                sum += j;
            }
        }
        System.out.println(sum);
    }
}
