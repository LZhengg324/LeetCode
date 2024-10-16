package _3194_minimumAverage;

import java.util.Arrays;

public class _3194_minimumAverage {
}

class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        double res = (nums[0] + nums[n - 1]) / 2.0;
        for (int i = 1; i < n / 2; i++) {
            res = Math.min(res, (nums[i] + nums[n - 1 - i]) / 2.0);
        }
        return res;
    }
}