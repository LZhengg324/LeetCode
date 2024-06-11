package longestPalindrome;

public class longestPalindrome {
    public static void main(String[] args) {
        System.out.println(new Solution1().longestPalindrome("bb"));
    }
}

class Solution1 {   //动态规划
    public String longestPalindrome(String s) {
        int down = 0, up = 0, max = 0;
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
//                if (i > j) {
//                    dp[i][j] = false;
//                    continue;
//                }
                if (j == i) {
                    dp[i][j] = true;
                } else if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                } else if (i + 1 > j - 1) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && j - i > max) {
                    max = j - i;
                    down = i;
                    up = j;
                }
            }
        }
        return s.substring(down, up + 1);
    }
}

class Solution2 {    //中心扩散
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int start = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int lenOdd = expandAround(i, i, s);
            int lenEven = expandAround(i, i + 1, s);
            int len = Math.max(lenOdd, lenEven);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int expandAround(int left, int right, String s) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
