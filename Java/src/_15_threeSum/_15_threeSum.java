package _15_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_threeSum {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{1,-1,-1,0}));
    }
}

class Solution {    //双指针法+排序
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int right = nums.length - 1;
            for (int left = i + 1; left < nums.length; left++) {
                if (left != i + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                while (nums[left] + nums[right] + nums[i] > 0 && left < right) {
                    right--;
                }
                if (left >= right) {
                    break;
                }
                if (nums[left] + nums[right] + nums[i] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}
