package LeetCode;


public class NumberOfGoodPairs_1512 {
    // Runtime 75.16%
    // Memory 99.66%
        public static int Solution_1(int[] nums) {
            int wynik = 0;
            for(int i = 0;i < nums.length;i++){
                for(int j = 1;j< nums.length;j++){
                    if(nums[i] == nums[j]&&i<j){
                        wynik++;
                    }
                }
            }
            return wynik;
        }


    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        System.out.println(Solution_1(nums));
    }
}
