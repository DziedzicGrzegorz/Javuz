package UZ.Grzesiek.Lab4_P;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;

/**
Stworzyć tablicę 7 x 7 liczb całkowitych, wypełnić ją losowymi wartościami, następnie
wyznaczyć dla każdej kolumny minimum i maksimum, najmniejszy oraz największy
element w tablicy, średnią arytmetyczną elementów tablicy, ilość elementów
mniejszych oraz większych od średniej. Do nowej tablicy skopiować w odwrotnej
kolejności zawartość tablicy tj. od ostatniego do pierwszego
*/
public class Zad2 {
    //@TODO sprawidzić czy to wszystko wgl działa
    Integer[][] matrix;

    public Zad2() {}

    public Zad2(int j) {
        matrix = new Integer[j][j];
    }


    public static void main(String[] args) {
        Zad2 test = new Zad2(7);
        test.insertRandomIntToArr(0, 100);
        test.displayTwoDArray(test.matrix);
        System.out.println(Arrays.toString(test.maxInEachCol()));
    }

    public void insertRandomIntToArr(int lowerBound, int uppedBound) {
        SecureRandom randomGen = new SecureRandom();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = randomGen.nextInt(lowerBound, uppedBound);
            }
        }

    }
    public Integer[] MaxInEachRow(){
        Integer[] minMaxInEachRow = new Integer[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            minMaxInEachRow[i] = Collections.max(Arrays.asList(matrix[i]));
        }
        return minMaxInEachRow;
    }
    public Integer[] maxInEachCol() {
        Integer[] maxesOfCols = new Integer[matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] > max) {
                    max = matrix[j][i];
                }
            }
            maxesOfCols[i] = max;
        }
        return maxesOfCols;
    }

    public void displayTwoDArray(Integer[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
    }

    public Integer[][] invertMatrix() {
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        Integer[][] invertedMatrix = new Integer[rowSize][columnSize];

        // for each row
        for (int i = 0; i < rowSize; i++) {
            // for each column, copy the elements in reverse order
            for (int j = 0; j < columnSize; j++) {
                invertedMatrix[i][j] = matrix[rowSize - i -1][columnSize - 1 - j];
            }
        }
        return invertedMatrix;
    }
    public Integer average(){
        double sum = 0.0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return (int) (sum / (matrix.length * matrix[0].length));
    }
    public Integer[] countElementsRelativeToAverage() {
        double average = average();
        int countGreater = 0;
        int countSmaller = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                if(matrix[i][j] > average) {
                    countGreater++;
                } else if(matrix[i][j] < average) {
                    countSmaller++;
                }
            }
        }
        return new Integer[]{countSmaller, countGreater};
    }
    public Integer maxValueInMatrix(){
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                if(matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }
    public Integer minValueInMatrix(){
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }
}