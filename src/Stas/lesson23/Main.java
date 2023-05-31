package Stas.lesson23;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number:");
        int user = scan.nextInt();
        System.out.println("Enter the first divisor:");
        int firstDivider = scan.nextInt();
        System.out.println("Enter the second divisor:");
        int secondDivider = scan.nextInt();
        int checkFirstDivider = 0;
        int checkSecondDivider = 0;

        for (int i = 1; i <= user ; i++) {
            if (i % firstDivider == 0) {
                checkFirstDivider += i;
            } else if (i % secondDivider == 0) {
                checkSecondDivider += i;
            }
        }
        System.out.println("The sum of the divisors is: " + (checkFirstDivider + checkSecondDivider));
    }
}
