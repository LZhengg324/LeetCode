package _3250_countOfPairs;

public class _3250_countOfPairs {
}

class Solution {

    final int MOD = 1000000000 + 7;

    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][51];
        for (int i = 0 ; i <= nums[0]; i += 1) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int v2 = 0; v2 <= nums[i]; v2 += 1) {
                for (int v1 = 0; v1 <= v2; v1 += 1) {
                    // 能构成arr2
                    if (nums[i - 1] - v1 >= nums[i] - v2) {
                        dp[i][v2] = (dp[i][v2] + dp[i - 1][v1]) % MOD;
                    }
                }
            }
        }
        int res = 0;
        for (int v : dp[n - 1]) {
            res = (res + v) % MOD;
        }
        return res;
    }
}