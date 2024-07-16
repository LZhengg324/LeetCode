package _3040_maxOperations;

import java.util.Arrays;

public class _3040_maxOperations {
    public static void main(String[] args) {
        System.out.println(new Solution().maxOperations(new int[]{3,2,6,1,4}));
    }
}

class Solution {
    private int[][] dp;
    private int[] nums;
    public int maxOperations(int[] nums) {
        this.nums = nums;
        this.dp = new int[nums.length][nums.length];
        int left = 0, right = nums.length - 1;
        int ans = 0;
        ans = Math.max(ans, initial(left, right, nums[left] + nums[left + 1]));
        ans = Math.max(ans, initial(left, right, nums[right] + nums[right - 1]));
        ans = Math.max(ans, initial(left, right, nums[left] + nums[right]));
        return ans;
    }

    public int initial(int left, int right, int target) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(left, right, target);
    }

    public int dfs(int left, int right, int target) {
        if (left >= right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int ans = 0;
        if (nums[left] + nums[left + 1] == target) {
            ans = Math.max(ans, dfs(left + 2, right, target) + 1);
        }
        if (nums[right] + nums[right - 1] == target) {
            ans = Math.max(ans, dfs(left, right - 2, target) + 1);
        }
        if (nums[left] + nums[right] == target) {
            ans = Math.max(ans, dfs(left + 1, right - 1, target) + 1);
        }
        dp[left][right] = ans;
        return ans;
    }
}