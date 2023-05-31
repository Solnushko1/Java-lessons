package Stas.lesson21;

import java.util.Scanner;

public class Numpad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter numbers:");
        String num = scan.nextLine();
        String output = "";
        for (int i = 0; i < num.length(); i++) {
            switch (num.charAt(i)) {
                case ('1') -> num = num.substring(0, i) + '7' + num.substring(i + 1);
                case ('2') -> num = num.substring(0, i) + '8' + num.substring(i + 1);
                case ('3') -> num = num.substring(0, i) + '9' + num.substring(i + 1);
                case ('7') -> num = num.substring(0, i) + '1' + num.substring(i + 1);
                case ('8') -> num = num.substring(0, i) + '2' + num.substring(i + 1);
                case ('9') -> num = num.substring(0, i) + '3' + num.substring(i + 1);
            }
        }
        System.out.println(num);


    }
}

