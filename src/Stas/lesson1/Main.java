package Stas.lesson1;

import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Размер строк: ");
        int lines = scan.nextInt();
        System.out.println("Размер столбцов: ");
        int columns = scan.nextInt();
        int count = 0;
        int[][] matrix = new int[lines][columns];
        System.out.println("Исходная матрица");
        for (int i = 0; i < lines; i++) {
           for (int j = 0; j < columns; j++) {
               matrix[i][j] = rand.nextInt(9) + 1;
               System.out.print(matrix[i][j] + " ");
           }
            System.out.println();
       }
        for (int i = 0; i < lines; i++){
            for (int j = i + 1; j < columns; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println("Транспортированная матрица");
        for(int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}