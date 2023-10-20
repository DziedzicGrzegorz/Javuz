package CodeWars;

import java.util.Arrays;

public class PersistentBugger {
    public static void main(String[] args) {
        PersistentBugger temp = new PersistentBugger();
        System.out.println(temp.solution_1(39));

    }

   // Time: ~2346ms
    public int solution_1(long num) {

        String sol = String.valueOf(num);
        int count = 0;

        while (sol.length() > 1) {
            String[] temp = sol.split("");
            long tmp = Arrays.stream(temp).mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b);
            sol = String.valueOf(tmp);
            count++;
        }

        return count;
    }


}
