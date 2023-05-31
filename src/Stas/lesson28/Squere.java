package Stas.lesson28;
import java.util.Scanner;
public class Squere {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        int N = scan.nextInt();

        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                int j = N / i;

                if ((i + j) % 2 == 0 && (j - i) % 2 == 0) {
                    int x = (i + j) / 2;
                    int y = (j - i) / 2;

                    if ((x >= 1) && (x < 100000) && (y >= 1) && (y < 100000)) {
                        System.out.println("Square difference: " + x*x + "-" + y*y);
                        System.out.println("The necessary numbers: " + x + " " + y);
                    }
                }
            }
        }
    }
}
