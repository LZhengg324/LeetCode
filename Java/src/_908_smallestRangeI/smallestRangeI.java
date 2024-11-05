package _908_smallestRangeI;

import java.util.Arrays;

public class smallestRangeI {
}

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int maxNum = Arrays.stream(nums).max().getAsInt();
        return maxNum - minNum >= 2 * k ? maxNum - minNum - 2 * k : 0;
    }
}