package LeetCode;

import java.util.HashSet;

public class TwoSum_1 {
    //runtime beats 32%
    //memory beats 66%
        public int[] solution_1(int[] nums, int target) {
            int dlugosc = nums.length;
            for(int i = 0;i<dlugosc;i++){
                for(int j = i + 1;j < dlugosc;j++)
                    if(nums[i] + nums[j] == target){
                        return new int []{i,j};
                    }
            }
            return new int []{0,0};
        }
    }
