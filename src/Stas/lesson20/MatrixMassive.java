package Stas.lesson20;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class MatrixMassive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int m = scan.nextInt();
        System.out.println("Enter number of columns:");
        int n = scan.nextInt();
        int shell = 1;
        int lesser = Math.min(m, n) / 2;

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = shell;
        }
    }
        for (int i = 1; i <= lesser; i++) {
            int num = i + 1;
            for (int j = i; j < n - i; j++) {
                matrix[i][j] = num;
                matrix[m - i - 1][j] = num;
            }
            for (int j = i; j < m - i; j++) {
                matrix[j][i] = num;
                matrix[j][n - i - 1] = num;
            }
        }
        try {
            FileWriter writer = new FileWriter("output.txt");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    writer.write(matrix[i][j] + " ");
                }
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
