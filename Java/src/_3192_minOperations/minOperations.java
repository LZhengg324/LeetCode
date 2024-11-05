package _3192_minOperations;

public class minOperations {
}

class Solution {
    public int minOperations(int[] nums) {
        int operation = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                operation += 1;
            }
        }
        return nums[0] == 1 ? operation : operation + 1;
    }
}