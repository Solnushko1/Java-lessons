package Stas.lesson18;

import java.util.Arrays;
import java.util.Scanner;

public class Massive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter numbers for array: ");
        String inputString = scan.nextLine();
        String[] inputArray = inputString.split(" ");
        int[] input = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            input[i] = Integer.parseInt(inputArray[i]);
        }

        int maxIndex = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i] > input[maxIndex]) {
                maxIndex = i;
            }
        }

        int[] leftArray = Arrays.copyOfRange(input, 0, maxIndex);
        int[] rightArray = Arrays.copyOfRange(input, maxIndex + 1, input.length);

        System.out.println("Left array: " + Arrays.toString(leftArray));
        System.out.println("Right array: " + Arrays.toString(rightArray));
    }
}
