package UZ.Grzesiek.Lab3_P;

import java.security.SecureRandom;


/**
 * The {@code Zad3} class is a sub-class of {@code Zad1} that implements a number guessing game.
 * It allows the user to guess a randomly generated number within a given range.
 *
 * <p> It contains the following methods:
 *
 * <ul>
 * <li> {@code public static void main(String[] args)}:
 *      The entry point of the program.
 *
 * <li> {@code public Zad3(int lowerBandIncluded, int upperBandExcluded)}:
 *      Constructs a new instance of the {@code Zad3} class.
 *      It calls the {@code startGame} method to begin the game.
 *
 * <li> {@code public void startGame(int lowerBandIncluded, int upperBandExcluded)}:
 *      Starts the number guessing game.
 *      It checks if the lower band is lower than the upper band.
 *      It calls the {@code randomInteger} method to generate a random number and the
 *      {@code userGuessTheNumber} method to prompt the user to guess the number.
 *
 * <li> {@code public void randomInteger(int lowerBandIncluded, int upperBandExcluded)}:
 *      Generates a random integer between the lower band (inclusive) and the upper band (exclusive).
 *      The generated number is stored in the {@code userNumberToGuess} field.
 *
 * <li> {@code public void userGuessTheNumber(int numberToGuess, int lowerBandIncluded, int upperBandExcluded)}:
 *      Prompts the user to guess the number within the specified range.
 *      It compares the user's input with the generated number and displays appropriate messages.
 *
 * <li> {@code public class Zad1} methods:
 *      The {@code Zad3} class extends the {@code Zad1} class and inherits all its public methods.
 *      These methods can be used to perform simple operations on integer values and display statistics.
 *      Refer to the {@code Zad1} class documentation for more details.
 * </ul>
 * @see Zad1
 */
public class Zad3 extends Zad1 {
    protected int userNumberToGuess;

    public static void main(String[] args) {

        Zad3 test = new Zad3(0,201);
    }

    public Zad3(int lowerBandIncluded, int upperBandExcluded) {
        super();
        startGame(lowerBandIncluded,upperBandExcluded);
    }
    public void startGame(int lowerBandIncluded, int upperBandExcluded) {
        if(lowerBandIncluded >= upperBandExcluded) {
            throw new IllegalArgumentException("Lower band must be lower than upper band");
        }
        randomInteger(lowerBandIncluded, upperBandExcluded);
        userGuessTheNumber(userNumberToGuess, lowerBandIncluded, upperBandExcluded);
    }

    public void randomInteger(int lowerBandIncluded, int upperBandExcluded) {
        SecureRandom rand = new SecureRandom();

        userNumberToGuess = rand.nextInt(lowerBandIncluded, upperBandExcluded);
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
