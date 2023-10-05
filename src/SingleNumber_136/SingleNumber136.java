package SingleNumber_136;

import java.util.HashSet;
import java.util.Iterator;


public class SingleNumber136 {
    public static void main(String[] args) {

        int unique = solution(new int[]{1, 2, 2});
        System.out.println(unique);
    }

    //Runtime ~28.05%
    //Memory ~99.02%
    public static int solution(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();

        for (int num : nums) {
            if (!unique.remove(num)) {
                unique.add(num);
            }
        }

        Iterator<Integer> it = unique.iterator();
        return it.next();
    }

}
