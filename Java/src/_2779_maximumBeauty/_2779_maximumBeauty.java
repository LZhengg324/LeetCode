package _2779_maximumBeauty;

import java.util.Arrays;

public class _2779_maximumBeauty {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int res = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < n; i++) {
            while (nums[i] - 2 * k > nums[j]) {
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
