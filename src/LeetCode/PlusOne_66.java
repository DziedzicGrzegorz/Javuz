package LeetCode;

public class PlusOne_66 {
    public static void main(String[] args) {

    }
    //Runtime ~100%
    //Memory ~67%
    //test mastera
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] tmp = new int[digits.length + 1];
        tmp[0] = 1;
        return tmp;
    }
}
