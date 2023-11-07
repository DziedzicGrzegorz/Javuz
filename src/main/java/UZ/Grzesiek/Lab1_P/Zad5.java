package UZ.Grzesiek.Lab1_P;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The Zad5 class represents a simple calculator that performs basic arithmetic operations
 * such as addition, subtraction, multiplication, and division.
 */
public class Zad5 {
    private double result;
    final private String[] allowedOperator = {"+", "-", "*", "/"};

    public static void main(String[] args) {
        Zad5 test = new Zad5();
        test.runCalculator();
    }

    public void add(double number) {
        result += number;
    }

    public void subtract(double number) {
        result -= number;
    }

    public void multiply(double number) {
        result *= number;
    }

    public void divide(double number) throws Exception {
        if (number == 0) {
            throw new Exception("You can't divide by 0");
        }
        result /= number;
    }

    public void clear() {
        result = 0;
    }

    public void displayResult() {
        System.out.println(STR."Result of your operations is \{result}");
    }

    public void runCalculator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter initial number:" + "If you want to Quit just press Q and enter");
        result = takeUserDoubleInLoopIfInvalid(scanner);


        while (true) {
            System.out.println("Enter operation: (+,-,*,/):");
            String validUserOperation = takeUserOperationInLoopIfInvalid(scanner);

            System.out.println("Enter number:");
            double validNumberToOperate = takeUserDoubleInLoopIfInvalid(scanner);

            try {
                mathOperations(validUserOperation, validNumberToOperate);
                displayResult();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private double takeUserDoubleInLoopIfInvalid(Scanner scanner) {
        while (true) {
            String userInput = scanner.nextLine();

            try {
                return Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                brakeProgramIfQuitCommand(userInput, scanner);
                System.out.println("Wrong input. Try again.");
            }
        }
    }

    private String takeUserOperationInLoopIfInvalid(Scanner scanner) {
        while (true) {
            String userOperation = scanner.nextLine().trim();

            if (Arrays.asList(allowedOperator).contains(userOperation)) {
                return userOperation;
            }
            brakeProgramIfQuitCommand(userOperation, scanner);
            System.out.println("Operation not allowed Try again");
        }
    }

    private void brakeProgramIfQuitCommand(String input, Scanner scanner) {

        if (input.trim().equalsIgnoreCase("q")) {
            scanner.close();
            System.exit(0);
        }
    }

    private void mathOperations(String operation, double userNumber) throws Exception {
        switch (operation) {
            case "+":
                add(userNumber);
                break;
            case "-":
                subtract(userNumber);
                break;
            case "*":
                multiply(userNumber);
                break;
            case "/":
                divide(userNumber);
                break;
            default:
                System.out.println("Invalid operation");
        }
    }
}