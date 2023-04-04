package Stas.lesson11;
import java.util.Scanner;
public class ReplaceVowels {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String[] rus = {"у", "е", "ё", "ы", "а", "о", "я", "и", "ю", "э"};
        for (String s: rus) {
            text = text.replace(s, "");
            text = text.replace(s.toUpperCase(), "");
        }
        System.out.println(text);
    }
}

