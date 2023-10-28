package Stas.lesson32;
import java.util.Scanner;
public class StickGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of sticks: ");
        long n = scan.nextLong();
        String winner = findWinner(n, "Саша");
        System.out.println("The winner is " + winner + ".");
    }
    public static String findWinner(long n, String player) {
        if (n == 1) {
            return player;
        } else if (n % 2 == 0) {
            return findWinner(n / 2, player.equals("Саша") ? "Таня" : "Саша");
        } else {
            return player;
        }
    }
}
