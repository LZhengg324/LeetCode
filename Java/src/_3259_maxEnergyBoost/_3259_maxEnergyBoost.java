package _3259_maxEnergyBoost;

public class _3259_maxEnergyBoost {
}

class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] dp = new long[n + 1][2];
        dp[1][0] = energyDrinkA[0];
        dp[1][1] = energyDrinkB[0];
        for (int i = 1; i < n; i++) {
            dp[i + 1][0] = Math.max(dp[i][0] + energyDrinkA[i], dp[i - 1][1] + energyDrinkA[i]);
            dp[i + 1][1] = Math.max(dp[i][1] + energyDrinkB[i], dp[i - 1][0] + energyDrinkB[i]);
        }
        return Math.max(dp[n][0], dp[n][1]);
    }
}