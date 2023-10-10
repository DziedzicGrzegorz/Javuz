package LeetCode;

import java.util.Arrays;

public class MinimumNumberofOperationstoMakeArrayContinuous_2009 {
    public static void main(String[] args) {
        MinimumNumberofOperationstoMakeArrayContinuous_2009 toTest = new MinimumNumberofOperationstoMakeArrayContinuous_2009();
        int unique = toTest.solution_1(new int[]{4, 2, 5, 3});


    }

    public int solution_1(int[] nums) {
        Arrays.sort(nums);
        int lengthMinus1 = nums.length - 1;
        int maxElMinusLength = nums[lengthMinus1] - lengthMinus1;
        int step = 0;

        if (nums[lengthMinus1] - nums[0] <= lengthMinus1) {
            return 0;
        }

        nums[0] = maxElMinusLength;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                nums[i]++;
                step++;
            }


        }

        return step;
    }
}
