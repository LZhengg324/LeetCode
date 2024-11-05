package _260_singleNumber;

public class _260_singleNumber {
}

class Solution {
    public int[] singleNumber(int[] nums) {
        int mask = 0;
        for (int num : nums) {
            mask ^= num;
        }
        int typeA = 0, typeB = 0;
        mask = (mask == Integer.MIN_VALUE ? mask : mask & (-mask));
        for (int num : nums) {
            if ((mask & num) != 0) {
                typeA ^= num;
            } else {
                typeB ^= num;
            }
        }
        return new int[]{typeA, typeB};
    }
}