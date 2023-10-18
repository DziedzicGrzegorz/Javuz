package Errory;

import java.util.Arrays;
import java.util.function.Predicate;

class Testowanie {

    public static void main(String[] args) throws Exception {
//      Double[][] mockParam = new Double[][]{{1000.0, 2.0}, {1000.0, 2.0}, {1.0, 2.0}, {1.0, 2.0}};

        ErrorHandler guard = new ErrorHandler();
//        guard.exceptionGuard(mockParam, "Error", params -> params[0] == params[1], params -> params[1] < 0, params -> params[1] <= 0, params -> params[0] > 100 * params[1]);

        guard.exceptionGuard(new String[][]{{"Hello","Hella"}, {"World","Gello"}}, "ErrorString",
                params -> {
                    System.out.println(Arrays.toString(params));
                   return  params[0].equals(params[1]);
                },
                params -> {
                    System.out.println(params[1]);
                   return params[1].equals("Hello");
                }

        );
    }
}

