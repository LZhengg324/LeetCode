package _540_singleNonDuplicate;

public class _540_singleNonDuplicate {
}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = -1, r = n / 2;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (nums[mid * 2] == nums[mid * 2 + 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return nums[r * 2];
    }
}