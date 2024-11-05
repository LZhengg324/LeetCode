package _910_smallestRangeII;

import java.util.Arrays;

public class smallestRangeII {
}

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int mi = nums[0], ma = nums[nums.length - 1];
        int res = ma - mi;
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i], b = nums[i + 1];
            res = Math.min(res, Math.max(ma - k, a + k) - Math.min(mi + k, b - k));
        }
        return res;
    }
}