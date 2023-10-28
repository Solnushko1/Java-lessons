package Stas.lesson34;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Accounting {
    public static int sumOfDigits(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + sumOfDigits(n / 10);
        }
    }
    public static List<Integer> sortByDigitSum(List<Integer> weights) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return sumOfDigits(i1) - sumOfDigits(i2);
            }
        };
        Collections.sort(weights, comparator);
        return weights;
    }
    public static void main(String[] args) {
        List<Integer> spisok = new ArrayList<Integer>();
        spisok.add(56);
        spisok.add(65);
        spisok.add(74);
        spisok.add(100);
        spisok.add(99);
        spisok.add(68);
        spisok.add(86);
        spisok.add(180);
        spisok.add(90);
        List<Integer> sortedWeights = sortByDigitSum(spisok);
        System.out.println(sortedWeights);
    }

}
