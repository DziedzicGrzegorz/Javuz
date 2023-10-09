package LeetCode;

public class TwoSum_1 {
    //runtime beats 32%
    //memory beats 66%
        public int[] solution_1(int[] nums, int target) {
            for(int i = 0;i<nums.length;i++){
                for(int j = i + 1;j < nums.length;j++)
                    if(nums[i] + nums[j] == target){
                        return new int []{i,j};
                    }
            }
            return new int []{0,0};
        }
    }
