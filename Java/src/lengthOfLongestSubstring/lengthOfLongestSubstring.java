package lengthOfLongestSubstring;

import java.util.HashSet;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new niubiSolution().lengthOfLongestSubstring("aaaa"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int right = -1;
        int ret = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            ret = Math.max(right - i + 1, ret);
        }
        return ret;
    }
}

class niubiSolution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        int[] window = new int[128];
        for (right = 0; right < s.length(); right++) {
            left = Math.max(left, window[s.charAt(right)]);
            window[s.charAt(right)] = right + 1;
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
