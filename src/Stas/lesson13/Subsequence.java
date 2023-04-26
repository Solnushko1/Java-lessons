package Stas.lesson13;

import java.util.Scanner;
public class Subsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the start of the series: ");
        int start = scan.nextInt();
        System.out.print("Enter the step for the series: ");
        int step = scan.nextInt();
        System.out.print("Enter the number of steps in the series: ");
        int n = scan.nextInt();
        System.out.print(start);
        for (int i = 1; i < n; i++) {
            start += step;
            System.out.print(", " + start);
        }
    }
}

