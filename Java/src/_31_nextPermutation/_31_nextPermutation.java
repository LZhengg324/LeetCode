package _31_nextPermutation;

import java.util.Arrays;

public class _31_nextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,5};
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
            i -= 1;
        }
        //最大字典序组合
        if (i == -1) {
            reverse(nums, 0);
            return;
        }
        //nums[0], nums[1], ...., nums[i], .... nums[nums.length - 1]
        //此时nums[i + 1] ~ nums[nums.length - 1]都为下降序列
        //在nums[i + 1] ~ nums[nums.length - 1]找到第一个j which a[i] < a[j]
        int j = nums.length - 1;
        while (j > 0) {
            if (nums[i] < nums[j]) {
                break;
            }
            j -= 1;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}