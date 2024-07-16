package _312_maxCoins;

public class _312_maxCoins {
    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{3,1,5,8}));
    }
}

class Solution {    //动态规划 dp[i][j]表示从第i个气球到第j个气球可获得的最大金币数
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] value = new int[len + 2];
        value[0] = 1;
        value[len + 1] = 1;
        System.arraycopy(nums, 0, value, 1, len);
        int[][] dp = new int[value.length + 1][value.length + 1];
        for (int i = len - 1; i >= 0; i--) {    //设左边界
            for (int j = i + 2; j <= len + 1; j++) { //设右边界
                for (int k = i + 1; k < j; k++) {
                    int val = value[i] * value[k] * value[j];
                    val += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(val, dp[i][j]);
                }
            }
        }
        return dp[0][len + 1];
    }
}