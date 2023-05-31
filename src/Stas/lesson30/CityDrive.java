package Stas.lesson30;
import java.util.ArrayList;
import java.util.Arrays;
public class CityDrive {
    public static ArrayList<Integer> chooseBestSum(int maxDistance, int city, int[] cityDistances) {
        ArrayList<Integer> bestCombination = null;
        int distance = 0;
        int[] indices = new int[city];
        for (int i = 0; i < city; i++) {
            indices[i] = i;
        }
        while (indices[0] <= cityDistances.length - city) {
            ArrayList<Integer> combination = new ArrayList<>();
            for (int index : indices) {
                combination.add(cityDistances[index]);
            }

            int combinationDistance = combination.stream().mapToInt(Integer::intValue).sum();
            if (combinationDistance <= maxDistance) {
                if (combinationDistance > distance) {
                    distance = combinationDistance;
                    bestCombination = combination;
                }
            }
            int i = city - 1;
            while (i >= 0 && indices[i] == cityDistances.length - city + i) {
                i--;
            }
            if (i < 0) {
                break;
            }
            indices[i]++;
            for (int j = i + 1; j < city; j++) {
                indices[j] = indices[j - 1] + 1;
            }
        }
        return bestCombination;
    }
    public static void main(String args[]) {
        int[] cityDistances = {50, 55, 57, 58, 60};
        int maxDistance = 163;
        int citiesToVisit = 3;
        ArrayList<Integer> bestCombination = chooseBestSum(maxDistance, citiesToVisit, cityDistances);
        if (bestCombination != null) {
            System.out.println("maxDistance: " + maxDistance);
            System.out.println("Best combination: " + Arrays.toString(bestCombination.toArray()));
        } else {
            System.out.println("No valid combinations found.");
        }
    }
}
