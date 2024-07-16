package _1480_runningSum;

public class _1480_runningSum {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] runningSum(int[] nums) {
        int cur = 0;
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            ret[i] = cur;
        }
        return ret;
    }
}