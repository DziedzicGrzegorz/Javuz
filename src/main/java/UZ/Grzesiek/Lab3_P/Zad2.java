package UZ.Grzesiek.Lab3_P;

import java.util.ArrayList;
import java.util.List;


/**
 * The {@code Zad2} class extends the {@link Zad1} class and provides additional functionality for calculating divider statistics of a user input number.
 *
 * <p> It consists of the following methods:
 *
 * <ul>
 * <li> {@code public List<Integer> getAllDivider(int numberToGetAllDivider)}:
 *      This method calculates all the dividers of a given number and returns a list of the dividers.
 *      If the method is invoked multiple times, the list will contain the dividers of the previously calculated number plus the dividers of the new number, so it is recommended to
 * clear the list before invoking the method again.
 *
 * <li> {@code public void displayStats()}:
 *      This method displays the statistical information for the user input number.
 *
 * <li> {@code public void clearAllDivider()}:
 *      This method clears the list of dividers.
 * </ul>
 * @see Zad1
 */
public class Zad2 extends Zad1 {
    List<Integer> allDividerOfUserInteger = new ArrayList<>();

    public static void main(String[] args) {
        Zad2 zad2 = new Zad2();
    }
    public Zad2(){
        super();
        getIntegerFromUserInLoopIfWrongType();
        getAllDivider(userInteger);
        displayStats();
    }


    public List<Integer> getAllDivider(int numberToGetAllDivider) {
        //if you invoke second time this method you will get all divider of previous number + new number so you need to clear list
        clearAllDivider();
        for (int i = 1; i <= numberToGetAllDivider; i++) {
            if (numberToGetAllDivider % i == 0) {
                allDividerOfUserInteger.add(i);
            }
        }
        return allDividerOfUserInteger;
    }

    public void displayStats() {
        System.out.println(STR."All divider: \{allDividerOfUserInteger.toString()}");
    }

    public void clearAllDivider() {
        allDividerOfUserInteger.clear();
    }

}
