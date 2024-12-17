package _581_findUnsortedSubarray;

public class _581_findUnsortedSubarray {
}

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[n - 1];
        int l = n - 1, r = 0;
        for (int i = 0; i < n; i += 1) {
            if (nums[n - i - 1] > min) {
                l = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
            if (nums[i] < max) {
                r = i;
            } else {
                max = nums[i];
            }
        }
        return l < r ? r - l + 1 : 0;
    }
}