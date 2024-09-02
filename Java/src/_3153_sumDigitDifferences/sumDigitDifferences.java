package _3153_sumDigitDifferences;

public class sumDigitDifferences {
    public static void main(String[] args) {
        System.out.println(new Solution().sumDigitDifferences(new int[]{13,23,12}));
    }
}

class Solution {
    public long sumDigitDifferences(int[] nums) {
        long res = 0;
        int n = nums.length;
        while (nums[0] > 0) {
            int[] cnt = new int[10];
            for (int i = 0; i < nums.length; i++) {
                cnt[nums[i] % 10]++;
                nums[i] /= 10;
            }
            for (int i = 0; i < 10; i++) {
                res += (long) cnt[i] * (n - cnt[i]);
            }
        }
        return res / 2;
    }
}