package Stas.lesson16;
import java.util.Scanner;
public class AAaa {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String inputString = scan.nextLine();

    int upperCount = 0;
    int lowerCount = 0;
    for (char c : inputString.toCharArray()) {
        if (Character.isUpperCase(c)) {
            upperCount++;
        } else if (Character.isLowerCase(c)) {
            lowerCount++;
        }
    }

    String resultString;
    if (upperCount > lowerCount) {
        resultString = inputString.toUpperCase();
    } else {
        resultString = inputString.toLowerCase();
    }

    System.out.println("Result: " + resultString);
}
}
