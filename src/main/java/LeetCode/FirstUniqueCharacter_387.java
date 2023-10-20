package LeetCode;

public class FirstUniqueCharacter_387 {
    class Solution {
        public int firstUniqChar(String s) {
            for (int i = 0; i < s.length(); i++) {
                char character = s.charAt(i);
                if (s.indexOf(character) == s.lastIndexOf(character)) {
                    return i;
                }
            }
            return -1;
        }
    }
    // Runtime 56.98%
    // Memory 70.53%
}
