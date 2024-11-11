package _1547_minCost;

import java.util.Arrays;

public class _1547_minCost {
}

//记忆化搜索
class Solution1 {
    public int minCost(int n, int[] cuts) {
        int[] wood = new int[cuts.length + 2];
        int[][] memo = new int[wood.length][wood.length];
        Arrays.sort(cuts);
        wood[0] = 0;
        wood[wood.length - 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            wood[i + 1] = cuts[i];
        }
        int res = Integer.MAX_VALUE;
        return dfs(0, wood.length - 1, wood, memo);
    }

    private int dfs(int i, int j, int[] wood, int[][] memo) {
        if (i + 1 == j) {
            return 0;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(i, k, wood, memo) + dfs(k, j, wood, memo));
        }
        memo[i][j] = res + wood[j] - wood[i];
        return memo[i][j];
    }
}

// 动态规划递推
class Solution2 {
    public int minCost(int n, int[] cuts) {
        int[] wood = new int[cuts.length + 2];
        int[][] dp = new int[wood.length][wood.length];
        Arrays.sort(cuts);
        wood[0] = 0;
        wood[wood.length - 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            wood[i + 1] = cuts[i];
        }
        for (int i = wood.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < wood.length; j++) {
                int res = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    res = Math.min(res, dp[i][k] + dp[k][j] + wood[j] - wood[i]);
                }
                dp[i][j] = res;
            }
        }
        return dp[0][wood.length - 1];
    }

    private int dfs(int i, int j, int[] wood, int[][] memo) {
        if (i + 1 == j) {
            return 0;
        }
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(i, k, wood, memo) + dfs(k, j, wood, memo));
        }
        memo[i][j] = res + wood[j] - wood[i];
        return memo[i][j];
    }
}