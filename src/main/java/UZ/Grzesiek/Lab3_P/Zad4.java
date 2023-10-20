package UZ.Grzesiek.Lab3_P;

import java.util.ArrayList;

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
                System.out.println(STR."Product of numbers: \{productOfNumbers}");

                break;

            }
            userInputs.add(userInput);
        }
    }

}
