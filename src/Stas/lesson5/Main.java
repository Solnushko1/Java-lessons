package Stas.lesson5;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите числа: ");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        int sum = 0;
        int dits;
        double square;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                dits = Character.getNumericValue(text.charAt(i));
                square = Math.pow(dits, 2);
                sum += square;
            }
        }
        System.out.println(sum);
    }
}
