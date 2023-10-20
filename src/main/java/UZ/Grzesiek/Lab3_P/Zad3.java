package UZ.Grzesiek.Lab3_P;

import java.security.SecureRandom;

public class Zad3 extends Zad1 {
    protected int userNumberToGuess;

    public static void main(String[] args) {
        Zad3 test = new Zad3(200,10);
    }

    public Zad3(int lowerBandIncluded, int upperBandExcluded) {
        randomInteger(lowerBandIncluded, upperBandExcluded);
    }
    public void startGame(int lowerBandIncluded, int upperBandExcluded) {
        userGuessTheNumber(userNumberToGuess, lowerBandIncluded, upperBandExcluded);
    }

    public int randomInteger(int lowerBandIncluded, int upperBandExcluded) {
        SecureRandom rand = new SecureRandom();

        int randNum = rand.nextInt(lowerBandIncluded, upperBandExcluded);
        userNumberToGuess = randNum;
        return randNum;
    }


    public void userGuessTheNumber(int numberToGuess, int lowerBandIncluded, int upperBandExcluded) {
        System.out.println(STR."Guess the number from \{lowerBandIncluded} to \{upperBandExcluded}");

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
