package UZ.Grzesiek.Lab3_P;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The {@code Zad1} class calculates simple operations on integer values.
 *
 * <p> It consists of four methods:
 *
 * <ul>
 * <li> {@code public boolean isPrimeNumber(int number)}:
 *      This method checks if a given integer number is a prime number.
 *      It returns true if the number is a prime number and false otherwise.
 *
 * <li> {@code public double evenToOddRatio(int number)}:
 *      This method calculates the ratio of the average of the even digits to the average of the odd digits in a given number.
 *
 * <li> {@code public int getIntegerFromUserInLoopIfWrongType()}:
 *      This method prompts the user to enter an integer until a correct integer is entered.
 *
 * <li> {@code public void displayStats()}:
 *      This method displays statistical information for userInteger.
 * </ul>
 */
public class Zad1 {
    protected int userInteger;

    public static void main(String[] args) {
        Zad1 zad1 = new Zad1();
        zad1.getIntegerFromUserInLoopIfWrongType();
        zad1.displayStats();
    }

    public boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public double evenToOddRatio(int number) {
        number = Math.abs(number);

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();


        while (number > 0) {
            if (number % 2 == 0) {
                even.add(number % 10);
            } else {
                odd.add(number % 10);
            }
            number /= 10;
        }

        if (odd.isEmpty() || even.isEmpty()) {
            return 0.0;
        }


        return even.stream().mapToInt(i -> i).average().getAsDouble()
                / odd.stream().mapToInt(i -> i).average().getAsDouble();
    }

    public int getIntegerFromUserInLoopIfWrongType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer: ");

        while (true) {
            String userInput = scanner.nextLine().trim();
            try {
                userInteger = Integer.parseInt(userInput);
                return userInteger;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Try again.");
            }
        }
    }

    public void displayStats() {
        System.out.println(STR."Is prime number: \{isPrimeNumber(userInteger)}");
        System.out.println(STR."Odd to even ratio: \{evenToOddRatio(userInteger)}");
    }
}
