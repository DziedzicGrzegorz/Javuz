package LeetCode;
import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber_136 {
    public static void main(String[] args) {
        SingleNumber_136 toTest = new SingleNumber_136();
        int unique = toTest.solution_1(new int[]{1, 2, 2});
        System.out.println(unique);
    }

    //Runtime ~28.05%
    //Memory ~99.02%
    public int solution_1(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();

        for (int num : nums) {
            if (!unique.remove(num)) {
                unique.add(num);
            }
        }

        Iterator<Integer> it = unique.iterator();
        return it.next();
    }
    //Jeśli chcesz dodać rozwiązanie stwórz swoją metodę poniżej tej linii


}
