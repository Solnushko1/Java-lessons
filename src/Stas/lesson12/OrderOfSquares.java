package Stas.lesson12;
import java.util.Scanner;
public class OrderOfSquares {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter end number");
        int finishNumber = scan.nextInt();
        System.out.println("Enter step");
        int step = scan.nextInt();
        String square = "";
        for (int i = 1; i <= finishNumber; i += step) {
            square += (int) Math.pow(i, 2) + ",";
        }
        System.out.println(square);
    }
}
