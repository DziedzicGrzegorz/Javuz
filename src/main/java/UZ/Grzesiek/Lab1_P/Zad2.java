package UZ.Grzesiek.Lab1_P;

import java.util.Arrays;

class Zad2 {
    public static void main(String[] args) throws Exception {
        System.out.print(Arrays.toString(Zad2.quadratic(1, 3, -15)));
    }

    private static double[] quadratic(double a, double b, double c) throws Exception {
        double delta = (Math.pow(b, 2) - 4 * a * c);

        if (delta < 0) {
            throw new Exception("No real roots in your quadratic equation");
        }
        if (delta == 0) {
            double rootEquation = -b / (2 * a);
            return new double[]{rootEquation};
        }
        if (delta > 0) {
            double squareOfDelta = Math.sqrt(delta);

            double firstRootEquation = (-b - squareOfDelta) / 2 * a;
            double secondRootEquation = (-b + squareOfDelta) / 2 * a;

            return new double[]{firstRootEquation, secondRootEquation};
        }


        return new double[]{};
    }
}

