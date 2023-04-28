package Stas.lesson19;
import java.util.Scanner;
public class Function {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("n: ");
        int n = scan.nextInt();
        System.out.println(fun(n));
    }
    public static int fun(int n) {
        //switch (n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return fun(n / 2);
        } else  {
            return fun( 1) + fun(n + 1);
        }
    }
}
