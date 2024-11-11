package _2461_maximumSubarraySum;

import java.util.HashSet;

public class _2461_maximumSubarraySum {
}

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int l = 0, r = 0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        long res = 0;
        while (r < n) {
            while (set.contains(nums[r]) || r - l > k - 1) {
                set.remove(nums[l]);
                sum -= nums[l];
                l += 1;
            }
            sum += nums[r];
            set.add(nums[r]);
            r += 1;
            if (set.size() == k) {
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}