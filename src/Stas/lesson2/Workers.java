package Stas.lesson2;
import java.util.ArrayList;
import java.util.Scanner;

public class Workers {

    private static final ArrayList<Integer> arrayList = new ArrayList<>();

    public static int countEmployees(ArrayList<Integer> input) {
        int count = 0;
        for (int value : input) {
            if (value == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an array of values in the format 1/0 separated by commas: ");
        String inputString = scanner.nextLine();
        char findingAComma;
        int checkDit = 0;
        String addToArrayList;
        for (int i = 0; i < inputString.length(); i++) {
            findingAComma = inputString.charAt(i);
            if (findingAComma == ',') {
                addToArrayList = inputString.substring(checkDit, i);
                arrayList.add(Integer.parseInt(addToArrayList));
                checkDit = i + 2;
            }
            if (i == inputString.length() - 1) {
                addToArrayList = inputString.substring(checkDit, i + 1);
                arrayList.add(Integer.parseInt(addToArrayList));
                checkDit = i + 2;
            }
        }
        int output = countEmployees(arrayList);
        System.out.println("Количество сотрудников: " + output);
    }
}