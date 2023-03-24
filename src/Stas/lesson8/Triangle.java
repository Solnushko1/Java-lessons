package Stas.lesson8;
import java.net.SocketOption;
import java.util.Scanner;
public class Triangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("a =");
        int a = scan.nextInt();
        System.out.println("b =");
        int b = scan.nextInt();
        System.out.println("c =");
        int c = scan.nextInt();
        if (checkTriangle(a, b, c)) {
            System.out.println("Треугольник возможен. " + angle(a, b, c));
        } else {
            System.out.println("Треугольник невозможен.");
        }
    }
    public static boolean checkTriangle(int a, int b, int c) {
        return ((a < b + c) && (b < a + c) && (c < b + a));
    }
    public static int angle(int a, int b, int c) {
        double angleA =180 - (Math.toDegrees(Math.acos(((Math.pow(b, 2)) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c))));
        double angleB =180 - (Math.toDegrees(Math.acos(((Math.pow(a, 2)) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c))));
        double angleC =180 - (Math.toDegrees(Math.acos(((Math.pow(b, 2)) + Math.pow(a, 2) - Math.pow(c, 2)) / (2 * b * a))));
        int maximumAngle = Math.max((int) angleA, (int) angleB);
        return Math.max(maximumAngle, (int) angleC);

    }
}
