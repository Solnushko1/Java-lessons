package Stas.lesson9;
import java.util.Scanner;
public class Strings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first line:");
        String firstText = scan.nextLine();
        System.out.println("Enter the second line:");
        String secondText = scan.nextLine();
        System.out.println(checkText(firstText,secondText));
    }
    private static boolean checkText(String firstText, String secondText) {
        return firstText.endsWith(secondText);
    }
}
