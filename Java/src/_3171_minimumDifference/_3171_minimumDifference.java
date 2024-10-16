package _3171_minimumDifference;

public class _3171_minimumDifference {
}

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.min(ans, Math.abs(nums[i] - k));
            int j = i - 1;
            while (j >= 0 && (nums[j] | nums[i]) != nums[j]) {
                nums[j] |= nums[i];
                ans = Math.min(ans, Math.abs(nums[j] - k));
                j -= 1;
            }
        }
        return ans;
    }
}