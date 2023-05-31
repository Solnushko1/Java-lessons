package Stas.lesson22;

public class Squere {
    public static double halfPerimeter(double a, double b, double c){
        double p = (a + b + c)/2;
        double squere = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return squere;
    }
}
