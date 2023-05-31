package Stas.lesson22;

import Stas.lesson3.Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a:");
        double a = scan.nextInt();
        System.out.println("Enter b:");
        double b = scan.nextInt();
        System.out.println("Enter c:");
        double c = scan.nextInt();
        double squere = Squere.halfPerimeter(a, b, c);
        System.out.println(squere);
    }
}
