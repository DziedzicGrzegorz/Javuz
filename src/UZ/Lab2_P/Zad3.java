package UZ.Lab2_P;

import java.security.SecureRandom;
import java.util.Scanner;

public class Zad3 extends Zad1 {
    protected int userNumberToGuess;

    public static void main(String[] args) {
        Zad3 zad3 = new Zad3(1, 201);
    }

    public Zad3(int loweBandIncluded, int upperBandExcluded) {
        randomInteger(loweBandIncluded, upperBandExcluded);
        userGuessTheNumber(userNumberToGuess, loweBandIncluded, upperBandExcluded);
    }

    private int randomInteger(int loweBandIncluded, int upperBandExcluded) {
        SecureRandom rand = new SecureRandom();
        // 1-200
        int randNum = rand.nextInt(loweBandIncluded, upperBandExcluded);
        userNumberToGuess = randNum;
        return randNum;

    }

    protected void userGuessTheNumber(int numberToGuess, int loweBandIncluded, int upperBandExcluded) {
        System.out.println(STR."Guess the number from \{loweBandIncluded} to \{upperBandExcluded}");

        while (true) {
            int userInput = getIntegerFromUserInLoopIfWrongType();

            if (userInput == numberToGuess) {
                System.out.println("You guessed!");
                break;
            } else if (userInput > numberToGuess) {
                System.out.println("Too big");
            } else {
                System.out.println("Too small");
            }

        }
    }

}
