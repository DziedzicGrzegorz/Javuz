package UZ.Grzesiek.Lab4_P;

import java.lang.reflect.Array;

public class Zad2Multi {
    Object matrix;

    public static void main(String[] args) {
        Zad2Multi test = new Zad2Multi(Integer.class, 3, 2, 3, 4);
        System.out.println(test.matrix);
    }


    public <T> Zad2Multi(Class<T> type, int dimension, int... sizes) {
        matrix = createMultiDimensionalArray(type, dimension, sizes, 0);
    }

    private <T> Object createMultiDimensionalArray(Class<T> type, int dimension, int[] sizes, int currentDimension) {
        int size = sizes[currentDimension];
        Object array = Array.newInstance(type, size);

        if(currentDimension < dimension - 1) {
            for (int i = 0; i < size; i++) {
                Array.set(array, i, createMultiDimensionalArray(type, dimension, sizes, currentDimension + 1));
            }
        }
        return array;
    }
    public void displayArray(){
        System.out.println();
    }
}