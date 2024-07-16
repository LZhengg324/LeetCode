package _53_maxSubArray;

public class _53_maxSubArray {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(pre, ans);
        }
        return ans;
    }
}