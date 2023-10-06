package UZ.Lab1_P.Grzeg;

import java.util.ArrayList;
import java.util.Scanner;

public class Zad4 {
    private double min;
    private double max;
    private double average;
    private int quantity;
    final private ArrayList<Double> numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Zad4 temp = new Zad4();
        temp.displayStats(12);
    }

    public Zad4() throws Exception {
        computeStats();
    }

    public void displayStats(int numbersAfterComma) throws IllegalArgumentException {
        if (numbersAfterComma < 0 || numbersAfterComma > 16) {
            throw new IllegalArgumentException("numbersAfterComma must be greater than 0 and less than 16");
        }

        String printFormat = "%." + numbersAfterComma + "f";

        System.out.println("Min: " + String.format(printFormat, this.min));
        System.out.println("Max: " + String.format(printFormat, this.max));
        System.out.println("Average: " + String.format(printFormat, this.average));
        System.out.println("Quantity: " + this.quantity);
    }


    private void computeStats() throws Exception {
        takeNumberFromUser();

        if (numbers.isEmpty()) {
            throw new Exception("No numbers to compute stats");
        }
        double sum = 0;
        this.quantity = numbers.size();

        for (double number : numbers) {
            this.min = Math.min(min, number);
            this.max = Math.max(max, number);
            sum += number;
        }
        this.average = sum / this.quantity;
    }


    private void takeNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number and confirm it with Enter. If you want to quit, press 'q' and Enter.");

        while (true) {
            String input = scanner.nextLine();
            try {
                double number = Double.parseDouble(input);
                numbers.add(number);
            } catch (NumberFormatException error) {
                if (input.equalsIgnoreCase("q")) {
                    break;
                } else {
                    System.out.println("Incorrect format, please enter again.");
                }
            }
        }
        scanner.close();
    }

    public double[] get() {
        return new double[]{this.min, this.max, this.average, this.quantity};
    }
}
