package _921_minAddToMakeValid;

public class _921_minAddToMakeValid {
}

class Solution {
    public int minAddToMakeValid(String s) {
        int leftBracket = 0;
        int res = 0;
        char[] chr = s.toCharArray();
        for (int i = 0; i < chr.length; i++) {
            if (chr[i] == '(') {
                leftBracket++;
            } else {
                if (leftBracket > 0) {
                    leftBracket--;
                } else {
                    res++;
                }
            }
        }
        return res + leftBracket;
    }
}