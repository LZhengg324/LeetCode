package _977_sortedSquares;

public class sortedSquares {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n - 1, k = n - 1;
        while (left <= right) {
            int temp;
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                temp = nums[left++];
            } else {
                temp = nums[right--];
            }
            res[k--] = temp * temp;
        }
        return res;
    }
}