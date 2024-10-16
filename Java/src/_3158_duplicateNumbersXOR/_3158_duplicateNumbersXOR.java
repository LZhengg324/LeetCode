package _3158_duplicateNumbersXOR;

public class _3158_duplicateNumbersXOR {
    public static void main(String[] args) {
        System.out.println(new Solution().duplicateNumbersXOR(new int[]{2,14,47,34,19,29,4,38,10,5,45,10,18,11,28,12,39,20,50,9,28,27,36,35,41,35,23,21,5,18,3,11,3,29,25,46,45,42,43,19}));
    }
}

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int res = 0;
        long mask = 0L;
        for (int num : nums) {
            if ((mask & (1L << num)) != 0) {
                res ^= num;
            } else {
                mask |= (1L << num);
            }
        }
        return res;
    }
}