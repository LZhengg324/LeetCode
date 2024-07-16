package _41_firstMissingPositive;

public class _41_firstMissingPositive {
    public static void main(String[] args) {

    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int temp;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}