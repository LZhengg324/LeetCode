package _3216_getSmallestString;

public class _3216_getSmallestString {
}

class Solution {
    public String getSmallestString(String s) {
        char[] chrs = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (chrs[i] < chrs[i - 1] && (chrs[i] - '0') % 2 == (chrs[i - 1] - '0') % 2) {
                char temp = chrs[i - 1];
                chrs[i - 1] = chrs[i];
                chrs[i] = temp;
                break;
            }
        }
        return new String(chrs);
    }
}