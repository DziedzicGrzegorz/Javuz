package Errory;

import java.util.function.Predicate;
//Dozwolone
//Number[] numArray = new Integer[1];
//numArray[0] = 1.0; // Rzuci ArrayStoreException

//Niedozwolone
//List<Number>[] numListArray = new List<Integer>[1]; // To jest nieprawidłowe
//
public class ErrorHandler {
    public static void main(String[] args) {
        ErrorHandler guard = new ErrorHandler();

    }

    private <T> T[] createArray(T... elements) {
        return elements;
    }
    private double sageVarTest(double... elements) {
        return elements[0];
    }

    @SafeVarargs
    public final <T> void exceptionGuard(T[][] params, String message, Predicate<T[]>... conditions) throws Exception {

        for (int i = 0; i < conditions.length; i++) {
//            System.out.println(STR."Jakie argumenty:\{i}\{Arrays.toString(params[i])}");
            if (conditions[i].test(params[i])) {
                throw new Exception(message);
            }
        }
    }

}

