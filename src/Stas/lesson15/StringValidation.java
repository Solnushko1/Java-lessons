package Stas.lesson15;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringValidation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a string with repeating words: ");
        String inputString = scan.nextLine();

        String[] words = inputString.split(" ");
        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            uniqueWords.add(word);
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (String uniqueWord : uniqueWords) {
            resultBuilder.append(uniqueWord).append(" ");
        }
        String resultString = resultBuilder.toString().trim();

        System.out.println("Result: " + resultString);
    }

}
