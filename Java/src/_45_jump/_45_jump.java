package _45_jump;

public class _45_jump {
    public static void main(String[] args) {

    }
}

class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int steps = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}