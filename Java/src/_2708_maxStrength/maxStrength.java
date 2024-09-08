package _2708_maxStrength;

public class maxStrength {
    public static void main(String[] args) {
        System.out.println('b'-'z');
    }
}

class Solution {
    public long maxStrength(int[] nums) {
        long mx = nums[0], mn = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long temp = mx;
            /*
            * 维护最大值四种选取方法:
            * 1. 不选nums[i]，则最大值不变
            * 2. 单独一个nums[i]即为最大值
            * 3. 若nums[i]为正数，mx * nums[i] 为最大值
            * 4. 若nums[i]为负数，mn * nums[i] 为最大值
            * */
            mx = Math.max(Math.max(mx, nums[i]), Math.max(mx * nums[i], mn * nums[i]));
            /*
             * 维护最小值四种选取方法:
             * 1. 不选nums[i]，则最小值不变
             * 2. 单独一个nums[i]即为最小值
             * 3. 若nums[i]为负数，mx * nums[i] 为最小值
             * 4. 若nums[i]为正数，mn * nums[i] 为最小值
             * */
            mn = Math.min(Math.min(mn, nums[i]), Math.min(mn * nums[i], temp * nums[i]));
        }
        return mx;
    }
}