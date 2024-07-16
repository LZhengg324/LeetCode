package _2786_maxScore;

public class _2786_maxScore {
    public static void main(String[] args) {
        System.out.println(new Solution().maxScore(new int[]{8,50,65,85,8,73,55,50,29,95,5,68,52,79}, 74));
    }
}

class Solution {
    public long maxScore(int[] nums, int x) {
        long ret = nums[0];
        long[] dp = new long[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        dp[nums[0] % 2] = nums[0];
        int parity;
        for (int i = 1; i < nums.length; i++) {
            parity = (int) nums[i] % 2;
            long cur = Math.max(dp[parity] + nums[i], dp[1 - parity] + nums[i] - x);
            ret = Math.max(ret, cur);
            dp[parity] = Math.max(dp[parity], cur);
        }
        return ret;
    }
}