package _76_minWindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _76_minWindow {
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map_t = new HashMap<>();
        HashMap<Character, Integer> map_s = new HashMap<>();
        int res = Integer.MAX_VALUE;
        int upper = -1, lower = -1;
        int i = 0, j = 0;
        for (Character ch : t.toCharArray()) {
            map_t.put(ch, map_t.getOrDefault(ch, 0) + 1);
        }
        while (j < s.length()) {
            if (!check(map_s, map_t)) {
                map_s.put(s.charAt(j), map_s.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            }
            while (check(map_s, map_t) && i < s.length()) {
                if (res > j - i) {
                    res = j - i;
                    upper = j;
                    lower = i;
                }
                map_s.put(s.charAt(i), map_s.getOrDefault(s.charAt(i), 0) - 1);
                i++;
            }
        }
        return lower == -1 ? "" : s.substring(lower, upper);
    }

    private boolean check(HashMap<Character, Integer> map_s, HashMap<Character, Integer> map_t) {
        for (Map.Entry<Character, Integer> entry : map_t.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (map_s.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}