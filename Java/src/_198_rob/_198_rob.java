package _198_rob;

public class _198_rob {
    public static void main(String[] args) {

    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 2) {
            if (nums.length == 1) {
                return nums[0];
            } else {
                return Math.max(nums[0], nums[1]);
            }
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
                continue;
            }
            if (i == 1) {
                dp[i] = Math.max(nums[0], nums[1]);
                continue;
            }
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}