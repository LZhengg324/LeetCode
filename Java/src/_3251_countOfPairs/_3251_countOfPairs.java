package _3251_countOfPairs;

import java.util.Arrays;

public class _3251_countOfPairs {
}

class Solution {
    public int countOfPairs(int[] nums) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        int m = Arrays.stream(nums).max().getAsInt();
        int[][] f = new int[n][m + 1];
        int[] g = new int[m + 1];

        Arrays.fill(f[0], 0, nums[0] + 1, 1);
        for (int i = 1; i < n; i++) {
            g[0] = f[i - 1][0];
            for (int j = 1; j <= m; j++) {
                g[j] = (g[j - 1] + f[i - 1][j]) % MOD;
            }
            for (int j = 0; j <= m; j++) {
                int k = Math.min(j, j + nums[i - 1] - nums[i]);
                if (k >= 0) {
                    f[i][j] = g[k];
                }
            }
        }

        int res = 0;
        for (int j = 0; j <= nums[n - 1]; j++) {
            res = (res + f[n - 1][j]) % MOD;
        }

        return res;
    }
}