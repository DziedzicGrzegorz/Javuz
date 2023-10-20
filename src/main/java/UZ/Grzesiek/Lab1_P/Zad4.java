package UZ.Grzesiek.Lab1_P;

import java.util.*;

public class Zad4 {
    private double min;
    private double max;
    private double average;
    private int quantity;
    final private ArrayList<Double> userNumbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Zad4 temp = new Zad4();
        temp.displayStats(12);
    }

    public Zad4() throws Exception {
        takeNumberFromUser();
        computeStats();
    }

    private void computeStats() throws Exception {

        if (userNumbers.isEmpty()) {
            throw new Exception("No numbers to compute stats");
        }
        quantity = userNumbers.size();
        min = Collections.min(userNumbers);
        max = Collections.max(userNumbers);

        double sum = 0;
        for (double number : userNumbers) {
            sum += number;
        }
        average = sum / quantity;
    }

    private void takeNumberFromUser() {

        Scanner scanner = new Scanner(System.in);
        printfInstructions();

        while (true) {
            String input = scanner.nextLine();
            if (isQuitCommand(input)) {
                break;
            }
            addNumber(input);
        }
        scanner.close();
    }

    private void addNumber(String input) {
                /*
        Podsumowując, używając Double.parseDouble(input),
        uzyskujesz wartość prymitywną double, ale kiedy dodajesz tę wartość do listy userNumbers,
        Java automatycznie przekształca tę wartość prymitywną na jej odpowiednik - typ obiektowy Double.
        Double.valueOf(input) --> obiekty Double
          */
        try {
//            double number = Double.parseDouble(input);
            Double number = Double.valueOf(input);

            userNumbers.add(number);
        } catch (NumberFormatException e) {
            System.out.println("Wrong input. Try again.");
        }
    }

    private void printfInstructions() {
        System.out.println("Enter a number and confirm it with Enter. If you want to quit, press 'q' and Enter or just Enter on empty line.");
    }

    private boolean isQuitCommand(String input) {
        String trimmedInput = input.trim();
        return trimmedInput.equalsIgnoreCase("q") || trimmedInput.isEmpty();
    }

    public void displayStats(int numbersAfterComma) throws IllegalArgumentException {
        if (numbersAfterComma < 0 || numbersAfterComma > 16) {
            throw new IllegalArgumentException("numbersAfterComma must be greater than 0 and less than 16");
        }

        String printFormat = "%." + numbersAfterComma + "f";

        System.out.println("Min: " + String.format(printFormat, min));
        System.out.println("Max: " + String.format(printFormat, max));
        System.out.println("Average: " + String.format(printFormat, average));
        System.out.println("Quantity: " + quantity);
    }


    public double[] get() {
        return new double[]{min, max, average, quantity};
    }
}
