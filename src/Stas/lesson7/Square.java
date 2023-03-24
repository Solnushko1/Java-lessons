package Stas.lesson7;
import java.util.Scanner;
public class Square {
    public static void main(String[] args) {
        System.out.println("Введите число:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int square = (int) Math.round(Math.sqrt(n));
        System.out.println(n + "->" +(int) Math.pow(square, 2) + "->" + square);
    }
}
