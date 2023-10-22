package LeetCode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomantoInteger_13 {


    public class mapy {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            String input = s.next();
            System.out.println("podany ciag znakow: "+input+"\nrowna sie: "+solution_1(input));
        }
        //Runtime 52.47%
        //Memory 37.81%
        public static int solution_1(String s){
            Map<Character,Integer>map = new HashMap<Character,Integer>();
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);

            int value = 0;
            for(int i = 0;i < s.length();i++){
                if(i < s.length() -1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                    value -= map.get(s.charAt(i));
                }
                else{
                    value += map.get(s.charAt(i));
                }
            }
            return value;
        }
    }
}
