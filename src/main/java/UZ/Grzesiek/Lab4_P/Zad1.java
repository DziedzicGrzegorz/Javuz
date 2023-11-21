package UZ.Grzesiek.Lab4_P;

import java.security.SecureRandom;
import java.util.Arrays;

/**
* Napisz program, w którym zostanie utworzona 30-elementowa tablica liczb typu int.
Za pomocą pętli zapisz w kolejnych komórkach liczby losowo wygenerowane z
przedziału od 99-150. Wykonać kopię do nowej tablicy.
* */
public class Zad1 {
    Integer[] arrayOfRandInt;
    public static void main(String[] args) {
        Zad1 test = new Zad1(30,99, 150);
        test.displayArray();

    }
    Zad1(){}
    Zad1(int size, int lowerBoundIncluded, int upperBoundIncluded){
        arrayOfRandInt = new Integer[size];
        tillArrayWithRandomNumbers(arrayOfRandInt, lowerBoundIncluded, upperBoundIncluded);

    }
    public void tillArrayWithRandomNumbers(Integer[] arr, int lowerBoundIncluded, int upperBoundIncluded){
        SecureRandom randomGenerator = new SecureRandom();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomGenerator.nextInt(lowerBoundIncluded, upperBoundIncluded+1);
        }
    }
    public Integer[] copy(){
        Integer[] copy = new Integer[arrayOfRandInt.length];
         System.arraycopy(arrayOfRandInt, 0,copy , 0, arrayOfRandInt.length);
            return copy;
    }
    public void displayArray(){
        System.out.println(Arrays.toString(arrayOfRandInt));
    }
}
