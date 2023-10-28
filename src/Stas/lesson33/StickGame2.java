package Stas.lesson33;
import java.util.Scanner;
public class StickGame2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of sticks: ");
        long n = scan.nextLong();

        long sashaSticks = n - sticksLeft(n, "Таня");
        long tanyaSticks = sticksLeft(n, "Таня");

        System.out.println("Саша will have " + sashaSticks + " sticks left.");
        System.out.println("Таня will have " + tanyaSticks + " sticks left.");
    }
    public static long sticksLeft(long n, String player) {
        if (n == 1) {
            if (player.equals("Таня")) {
                return 1;
            } else {
                return 0;
            }
        } else if (n % 2 == 0) {
            if (player.equals("Таня")) {
                long half = n / 2;
                if (half % 2 == 0) {
                    return sticksLeft(half, "Саша") + half;
                } else {
                    return sticksLeft(half + 1, "Саша") + half;
                }
            } else {
                return sticksLeft(n - 1, "Таня");
            }
        } else {
            return sticksLeft(n - 1, "Таня");
        }
    }

}
