package _3_romanToInt;

import java.util.HashMap;

public class _13_romanToInt {
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("LVIII"));
    }
}

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('M', 1000);
            put('D', 500);
            put('C', 100);
            put('L', 50);
            put('X', 10);
            put('V', 5);
            put('I', 1);
        }};
        int ans = 0;
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            value = map.get(s.charAt(i));
            if (i < s.length() - 1 && value < map.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}