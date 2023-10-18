package UZ.Lab2_P;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zad1 {
    protected int userInteger;

    public static void main(String[] args) {
        Zad1 zad1 = new Zad1();
        zad1.getIntegerFromUserInLoopIfWrongType();
        zad1.displayStats();

    }

    private boolean isPrimeNumber(int number) {
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

    private double oddToEvenRatio(int number) {
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

//        AtomicReference<Double> oddAverage = new AtomicReference<>();
//        AtomicReference<Double> evenAverage =  new AtomicReference<>();
//
//        odd.stream().mapToInt(i -> i).average().ifPresent(oddAverage::set);
//        even.stream().mapToInt(i -> i).average().ifPresent(evenAverage::set);

//      I check above that both lists are not empty
        return odd.stream().mapToInt(i -> i).average().getAsDouble()
                / even.stream().mapToInt(i -> i).average().getAsDouble();
    }

    protected int getIntegerFromUserInLoopIfWrongType() {
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
        System.out.println(STR."Odd to even ratio: \{oddToEvenRatio(userInteger)}");


    }

}
