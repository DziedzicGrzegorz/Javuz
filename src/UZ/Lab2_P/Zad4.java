package UZ.Lab2_P;

import java.util.ArrayList;
import java.util.List;

public class Zad4 extends Zad1 {
    List<Integer> userInputs = new ArrayList<>();

    public static void main(String[] args) {
        Zad4 zad4 = new Zad4();
    }

    public Zad4() {
        userGuessTheNumberWithoutHelp(5);
    }

    protected void userGuessTheNumberWithoutHelp(int numberToGuess) {
        System.out.println(STR."Guess the number");

        while (true) {
            int userInput = getIntegerFromUserInLoopIfWrongType();
            userInputs.add(userInput);

            if (userInput == numberToGuess) {
                System.out.println("You guessed!");

                int productOfNumbers = userInputs.stream().reduce(1, (a, b) -> a * b);
                System.out.println("Product of numbers: " + productOfNumbers);

                break;

            }

        }
    }

}
