package _209_minSubArrayLen;

public class _209_minSubArrayLen {
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0, r = 0;
        while (r < n) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}