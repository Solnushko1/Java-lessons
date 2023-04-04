package Stas.lesson10;
import java.util.Scanner;
public class Name {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scan.nextLine();
        name = name.substring(0,1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
        System.out.println("Hello, " + name + "!");
    }
}
