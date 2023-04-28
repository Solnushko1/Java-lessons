package Stas.lesson17;
import java.util.Scanner;

public class Brackets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter value: ");
        String brackets = scan.nextLine();
        System.out.println(bracketCheck(brackets));
    }

    private static boolean bracketCheck(String brackets) {
        char[] counter = brackets.toCharArray();
        int open = 0;
        int close = 0;
        for (char c : counter) {
            if (c == '(') {
                open += 1;
            } else if (c == ')') {
                close += 1;
            }
        }
        return open == close;
    }
}

