package UZ.Lab2_P;

import java.util.ArrayList;
import java.util.List;

public class Zad2 extends Zad1 {
    List<Integer> allDividerOfUserInteger = new ArrayList<>();

    public static void main(String[] args) {
        Zad2 zad2 = new Zad2();
        zad2.getIntegerFromUserInLoopIfWrongType();
        zad2.getAllDivider(zad2.userInteger);
        zad2.displayStats();
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
