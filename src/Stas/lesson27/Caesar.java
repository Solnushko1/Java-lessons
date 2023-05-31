package Stas.lesson27;
import java.util.Scanner;
public class Caesar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your message:");
        String message = scan.nextLine();
        System.out.print("Enter shift number:");
        int shift = scan.nextInt();
        System.out.print("Enter direction (encrypt - 'e', decrypt - 'd'):");
        String direction = scan.next();
        if (direction.equals("e")) {
            System.out.println("Encrypted message:" + encrypt(message, shift));
        }
        else if (direction.equals("d")) {
            System.out.println("Decoded message:" + decrypt(message, shift));
        }
        else {
            System.out.println("Wrong direction:" + direction);
        }
    }
    // Метод для шифрования сообщения с помощью шифра Цезаря
    public static String encrypt(String message, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                int code = Character.toUpperCase(ch) - 'A';
                code = (code + shift) % 26;
                char newCh = (char) ('A' + code);
                result.append(Character.isLowerCase(ch) ? Character.toLowerCase(newCh) : newCh);
            }
            else {
                result.append(ch);
            }
        }
        return result.toString();
    }
    // Метод для дешифрования сообщения с помощью шифра Цезаря
    public static String decrypt(String message, int shift) {
        return encrypt(message, 26 - shift);
    }
}
