package threeSumClosest;

import java.util.Arrays;

public class threeSumClosest {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{0,1,2}, 3));
        // -4 -1 1 2
    }
}

class Solution {    //排序+双指针
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                closet = Math.abs(target - (nums[i] + nums[left] + nums[right])) < Math.abs(target - closet) ? nums[i] + nums[left] + nums[right] : closet;
                if (nums[i] + nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] == target){
                    return nums[i] + nums[left] + nums[right];
                }
            }
        }
        return closet;
    }
}