package _10_isMatch;

public class _10_isMatch {
    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aab", "c*a*b"));
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;    //空字符串可以匹配空字符串
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {   //p字符串中的'*'
                    //s的第i个字符与p的第j个字符的匹配结果和s的第i个字符与p的第j-1个字符的匹配结果相同
                    //举例若s的第i个字符为'a',p的第j个字符为'*'
                    //则若j-1为'b',dp[i][j-1]应为false,因此dp[i][j]也为false
                    dp[i][j] = dp[i][j - 2];
                    //考虑可能'*'没有跟任意字符匹配的情况
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        } else if (p.charAt(j - 1) == '.') {
            return true;    //任意字符
        } else {
           return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }
}
