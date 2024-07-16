package _438_findAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438_findAnagrams {
    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("abab", "ab"));
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arrayS = new int[26];
        int[] arrayP = new int[26];
        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) {
            return ans;
        }

        for (int i = 0; i < p.length(); i++) {
            arrayS[s.charAt(i) - 'a']++;
            arrayP[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arrayS, arrayP)) {
            ans.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            arrayS[s.charAt(i) - 'a']--;
            arrayS[s.charAt(i + p.length()) - 'a']++;
            if (Arrays.equals(arrayS, arrayP)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
