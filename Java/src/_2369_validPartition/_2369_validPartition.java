package _2369_validPartition;

import java.util.Arrays;

public class _2369_validPartition {
}

class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i < n; i += 1) {
            if ((nums[i] == nums[i - 1] && dp[i - 1]) ||
                    (i > 1 && nums[i - 1] == nums[i] && nums[i - 1] == nums[i - 2] && dp[i - 2]) ||
                    (i > 1 && nums[i - 1] + 1 == nums[i] && nums[i - 2] + 1 == nums[i - 1] && dp[i - 2])) {
                dp[i + 1] = true;
            }
        }
        return dp[n];
    }
}