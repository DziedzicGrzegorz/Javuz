package UZ.Grzesiek.Lab7_P;


public class Zad1 {
    double result = 0.0;
    private double[] numbers;

    Zad1(double num1) {
        result = Math.sqrt(num1);
    }

    Zad1(double num1, double num2, double num3, double num4) {
        result = num1 + num2 + num3 + num4;
    }

    Zad1(double num1, double num2, double num3, double num4, double num5, double num6, double num7) {
        result = num1 * num2 * num3 * num4 * num5 * num6 * num7;
    }

    Zad1(Zad1 other) {
        this.numbers = other.numbers.clone();
    }

    void display() {
        System.out.println(result);
    }
}