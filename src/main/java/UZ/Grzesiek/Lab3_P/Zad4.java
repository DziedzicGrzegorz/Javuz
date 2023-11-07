package UZ.Grzesiek.Lab3_P;

import java.util.ArrayList;


/**
 * The {@code Zad4} class extends the {@code Zad1} class and implements a user guessing game.
 *
 * <p> It contains the following methods:
 *
 * <ul>
 * <li> {@code public Zad4()}:
 *      This constructor initializes the class by calling the method {@code userGuessTheNumberWithoutHelp(5)}.
 *
 * <li> {@code public void userGuessTheNumberWithoutHelp(int numberToGuess)}:
 *      This method prompts the user to enter numbers until they guess the specified number.
 *      It calculates and displays the product of all previous numbers once the user guesses the number correctly.
 *
 * <li> {@code public int getIntegerFromUserInLoopIfWrongType()}:
 *      This method prompts the user to enter an integer until a correct integer is entered.
 *      It returns the entered integer.
 * </ul>
 * @see Zad1
 */
public class Zad4 extends Zad1 {
    ArrayList<Integer> userInputs = new ArrayList<>();

    public static void main(String[] args) {
        Zad4 zad4 = new Zad4();
    }

    public Zad4() {
        userGuessTheNumberWithoutHelp(5);
    }

    public void userGuessTheNumberWithoutHelp(int numberToGuess) {
        System.out.println(STR."type nums or type 5 to multiply all previous numbers");

        while (true) {
            int userInput = getIntegerFromUserInLoopIfWrongType();

            if (userInput == numberToGuess) {

                int productOfNumbers = userInputs.stream().reduce(1, (a, b) -> a * b);
                System.out.println(STR."Product of all previous numbers: \{productOfNumbers}");

                break;
            }

            userInputs.add(userInput);
        }
    }
}
