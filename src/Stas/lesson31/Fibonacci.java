package Stas.lesson31;
import java.util.Arrays;
import java.util.Scanner;
public class Fibonacci {
    public static int[][] fibonacciDigitCount(int i) {
        int[] fib = new int[i+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int j = 2; j <= i; j++) {
            fib[j] = fib[j-1] + fib[j-2];
        }
        int[] digitCounts = new int[10];
        for (char number : Integer.toString(fib[i]).toCharArray()) {
            digitCounts[Character.getNumericValue(number)]++;
        }
        int maxNumb = -1;
        int maxCount = 0;
        for (int digit = 0; digit < 10; digit++) {
            if (digitCounts[digit] > maxCount) {
                maxNumb = digit;
                maxCount = digitCounts[digit];
            } else if (digitCounts[digit] == maxCount && maxNumb != -1) {
                maxNumb = Math.max(maxNumb, digit);
            }
        }
        return new int[][]{{maxCount, maxNumb}};
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer between 10 and 100000: ");
        int i = scan.nextInt();
        scan.close();
        int[][] result = fibonacciDigitCount(i);
        System.out.println("f(" + i + ") = " + Arrays.toString(result[0]));
    }
}
