package Stas.lesson3;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите координаты треугольника в формате ([x1, y1], [x2, y2], [x3, y3]): ");
        String inputString = scan.nextLine();
        inputString = inputString.replaceAll("[\\[\\]]", ""); // удаляем квадратные скобки
        String[] coordinates = inputString.split(", "); // разбиваем строку на массив координат
        int x1 = Integer.parseInt(coordinates[0]);
        int y1 = Integer.parseInt(coordinates[1]);
        int x2 = Integer.parseInt(coordinates[2]);
        int y2 = Integer.parseInt(coordinates[3]);
        int x3 = Integer.parseInt(coordinates[4]);
        int y3 = Integer.parseInt(coordinates[5]);

        double centerX = (x1 + x2 + x3) / 3.0; // координата X центра
        double centerY = (y1 + y2 + y3) / 3.0; // координата Y центра

        System.out.printf("{%.4f, %.4f}", centerX, centerY);
    }
}
