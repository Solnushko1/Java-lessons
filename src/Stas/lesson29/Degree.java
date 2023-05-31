package Stas.lesson29;
import java.util.Scanner;

public class Degree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = scan.nextInt();
        System.out.print("Enter the starting number of the row:");
        int start = scan.nextInt();
        int maxPow = (int) Math.sqrt(num);
        for (int w = 6; w >= 0; w--) {
            for (int q = start; q <= maxPow; q++) {
                int sum = 0;
                int s = 1;
                boolean found = false;
                for (int n = 1; ; n++) {
                    int pow = (int) Math.pow(q, n);
                    if (pow > num / s) {
                        break;
                    }
                    sum += digitPowerSum(pow, w+1);
                    s *= q;
                    if (num % s == 0 && sum == digitPowerSum(num / s, w)) {
                        System.out.println(q + "^" + n + " + ... = " + num / s + "*" + s);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    return;
                }
            }
        }
        System.out.println("Решение не найдено");
    }
    // Метод для вычисления суммы степеней цифр числа
    public static int digitPowerSum(int num, int pow) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += (int) Math.pow(digit, pow);
            num /= 10;
        }
        return sum;
    }
}


