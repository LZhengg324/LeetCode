package _189_rotate;

public class _189_rotate {

}

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverseNums(nums, 0, nums.length - 1);
        reverseNums(nums, 0, k - 1);
        reverseNums(nums, k, nums.length - 1);
    }

    private void reverseNums(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}