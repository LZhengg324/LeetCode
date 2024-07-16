package _18_fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_fourSum {
    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
    }
}

class Solution {    //双指针+排序
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int left, right;
        long tmp_target;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                tmp_target = target - (long)nums[i] - (long)nums[j];
                right = nums.length - 1;
                for (left = j + 1; left < nums.length; left++) {
                    if (left != j + 1 && nums[left] == nums[left - 1]) {
                        continue;
                    }
                    while(nums[left] + nums[right] > tmp_target  && left < right) {
                        right--;
                    }
                    if (left >= right) {
                        break;
                    }
                    if (nums[left] + nums[right] == tmp_target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ret.add(list);
                    }
                }
            }
        }
        return ret;
    }
}