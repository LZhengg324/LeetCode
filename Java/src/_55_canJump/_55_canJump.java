package _55_canJump;

public class _55_canJump {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int longestJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (longestJump >= i) {
                longestJump = Math.max(longestJump, i + nums[i]);
            }
            if (longestJump >= nums.length - 1) return true;
        }
        return false;
    }
}