package Stas.lesson4;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите строку");
        Scanner scanner1 = new Scanner(System.in);
        String userText = scanner1.nextLine();
        System.out.println("Введите букву");
        String userLetter = scanner1.nextLine();
        int count = 0;
        char userLetters = userLetter.charAt(0);
        for (int i = 0; i < userText.length(); i++) {
            char checkLetter = userText.charAt(i);
            if (userLetters == checkLetter) {
                count++;
            }
        }
        System.out.println(count);
    }
}
