package UZ.Lab2_P;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zad5 {
    int userInteger;
    List<Integer> calcNums = new ArrayList<>();

    public static void main(String[] args) {
        Zad5 zad5 = new Zad5();

    }

    public Zad5() {
        getIntegerFromUserInLoopIfWrongType();
        calculateNumsLessThanPow3(userInteger, 2);
        displayStats();
    }

    private List<Integer> calculateNumsLessThanPow3(int userIntegerToCalc, int power) {
        int num = power;
        while (num < userIntegerToCalc) {
            calcNums.add(num);
            num *= power;
        }
        return calcNums;

    }


    private int getIntegerFromUserInLoopIfWrongType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");

        while (true) {
            String userInput = scanner.nextLine().trim();
            try {
                int userInputParset = Integer.parseInt(userInput);
                if (userInputParset < 0) {
                    System.out.println("Integer must be positive. Try again.");
                    continue;
                }
                userInteger = userInputParset;
                return userInteger;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input. Try again.");
            }
        }
    }

    public void displayStats() {
        System.out.println(STR."Numbers: \{calcNums}");
    }

}
