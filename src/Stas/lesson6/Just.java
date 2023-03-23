package Stas.lesson6;
import java.util.Scanner;
public class Just {
    public static void main(String[] args) {
        System.out.println("Введите число:");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 2; i < n/2; i++) {
            if (n % i == 0) {
                System.out.println("Не простое");
                return;
            }
        }
        System.out.println("Простое");
    }
}
