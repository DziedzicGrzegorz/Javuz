package UZ.Grzesiek.Lab4_P;
/*
* Dla tablicy 40 elementowej komórkom o indeksach:
0-10 przypisz wartość od 1-5 losowo,
11-20 przypisz wartość od 6-10 losowo,
21-30 przypisz wartość od 11-55 losowo,
31-39 przypisz wartość od 60-75 losowo,
* */

import java.security.SecureRandom;
import java.util.Arrays;

public class Zad3 {
    Integer[] arrayOfRandInt;
    public static void main(String[] args) {
        Zad3 test = new Zad3(40);
        test.fillArrayWithRandomNumbers( 1, 5, 0, 10);
        test.fillArrayWithRandomNumbers( 6, 10, 11, 20);
        test.fillArrayWithRandomNumbers( 11, 55, 21, 30);
        test.fillArrayWithRandomNumbers( 60, 75, 31, 39);
        System.out.println(Arrays.toString(test.arrayOfRandInt));
    }
    Zad3(){}
    Zad3(int size){
        arrayOfRandInt = new Integer[size];
    }

    public void fillArrayWithRandomNumbers(int lowerBoundIncluded, int upperBoundIncluded, int start, int end) {
        SecureRandom randomGenerator = new SecureRandom();
        for (int i = start; i <= end; i++) {
            arrayOfRandInt[i] = randomGenerator.nextInt(lowerBoundIncluded, upperBoundIncluded+1);
        }
    }
}
