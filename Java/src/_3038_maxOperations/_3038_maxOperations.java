package _3038_maxOperations;

public class _3038_maxOperations {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxOperations(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[0] + nums[1] != nums[i] + nums[i + 1]) {
                break;
            }
            cnt++;
        }
        return cnt;
    }
}