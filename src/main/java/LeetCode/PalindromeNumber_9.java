package LeetCode;

public class PalindromeNumber_9 {
    public static boolean Solution_1(int x) {
        //Runtime 39.98%
        //Memory 25.82%

        String value = String.valueOf(x);
        int n = value.length();
        if(x < 0){
            return false;
        }
        for(int i = 0; i < n/2;i++){

            if(value.charAt(i) != value.charAt(n - i-1)){
                return false;
            }
        }
        return true;
    }

    public static boolean Solution_2(int x){
        //Runtime 21.13%
        //Memory 31.83%

        String value = String.valueOf(x);
        StringBuilder s = new StringBuilder(value);
        return s.reverse().toString().equals(value);
    }
    public static void main(String[] args) {
        int x = -121;
        System.out.println(Solution_1(x));
        System.out.println(Solution_2(x));
    }
}
