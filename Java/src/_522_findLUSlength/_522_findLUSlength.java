package _522_findLUSlength;

public class _522_findLUSlength {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean check = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && checkIsSubSeq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(strs[i].length(), ans);
            }
        }
        return ans;
    }

    private boolean checkIsSubSeq(String s1, String s2) {
        int pt1 = 0, pt2= 0;
        while (pt1 != s1.length() && pt2 != s2.length()) {
            if (s1.charAt(pt1) == s2.charAt(pt2)) {
                pt1++;
            }
            pt2++;
        }
        return pt1 == s1.length();
    }
}