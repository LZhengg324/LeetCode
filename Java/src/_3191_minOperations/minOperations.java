package _3191_minOperations;

public class minOperations {
}

class Solution {
    public int minOperations(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                cnt += 1;
                nums[i] = Math.abs(nums[i] - 1);
                nums[i + 1] = Math.abs(nums[i + 1] - 1);
                nums[i + 2] = Math.abs(nums[i + 2] - 1);
            }
        }
        return nums[nums.length - 1] == 1 && nums[nums.length - 2] == 1 ? cnt : -1;
    }
}