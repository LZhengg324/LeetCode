package _26_removeDuplicates;

public class _26_removeDuplicates {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1,1,2}));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            nums[cnt++] = nums[i];
        }
        return cnt;
    }
}