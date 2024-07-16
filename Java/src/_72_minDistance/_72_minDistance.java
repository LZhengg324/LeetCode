package _72_minDistance;

public class _72_minDistance {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() * word2.length() == 0) {
            return word1.length() + word2.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int left = dp[i][j - 1] + 1;
                int down = dp[i - 1][j] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down++;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}