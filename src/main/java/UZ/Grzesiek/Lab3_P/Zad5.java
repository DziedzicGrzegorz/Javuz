package UZ.Grzesiek.Lab3_P;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * The {@code Zad5} class is a subclass of {@code Zad1} and performs calculations based on user input.
 *
 * <p> It calculates a list of numbers less than a given power and displays statistical information.
 *
 * @see Zad1
 */
public class Zad5 extends Zad1 {
    List<Integer> calcNums = new ArrayList<>();

    public static void main(String[] args) {
        Zad5 zad5 = new Zad5();
    }

    public Zad5() {
        getIntegerFromUserInLoopIfWrongType();
        userInteger = Math.abs(userInteger);
        calculateNumsLessThanPow(userInteger, 3);
        displayStats();
    }

    public void calculateNumsLessThanPow(int userIntegerToCalc, int power) {
        int num = power;
        while (num < userIntegerToCalc) {
            calcNums.add(num);
            num *= power;
        }
    }

    public void displayStats() {
        System.out.println(STR."Numbers: \{calcNums}");
    }
}
