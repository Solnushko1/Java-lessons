package Stas.lesson14;
import java.util.Scanner;

public class NumbersList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = new int[3]; // массив для хранения чисел

        System.out.print("Enter a number: ");
        numbers[0] = scan.nextInt();

        System.out.print("Enter a number: ");
        numbers[1] = scan.nextInt();

        System.out.print("Enter a number: ");
        numbers[2] = scan.nextInt();

        // находим наименьшее число и заменяем его, если все ячейки заполнены
        if (numbers[0] != 0 && numbers[1] != 0 && numbers[2] != 0) {
            int minIndex = 0;
            for (int i = 1; i < 3; i++) {
                if (numbers[i] < numbers[minIndex]) {
                    minIndex = i;
                }
            }
            System.out.println("All three cells are filled. The smallest number (" + numbers[minIndex] + ") has been replaced with the last entered number.");
            numbers[minIndex] = numbers[2];
        }

        System.out.println("Numbers: " + numbers[0] + ", " + numbers[1] + ", " + numbers[2]);
    }
}
