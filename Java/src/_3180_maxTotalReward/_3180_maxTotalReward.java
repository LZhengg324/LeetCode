package _3180_maxTotalReward;

import java.util.Arrays;

public class _3180_maxTotalReward {
}

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int m = rewardValues[rewardValues.length - 1];
        int[] dp = new int[2 * m];
        dp[0] = 1;
        for (int x: rewardValues) {
            for (int i = 2 * x - 1; i >= x; i--) {
                if (dp[i - x] == 1) {
                    dp[i] = 1;
                }
            }
        }
        for (int i = 2 * m - 1; i >= 0; i--) {
            if (dp[i] == 1) {
                return i;
            }
        }
        return 0;
    }
}