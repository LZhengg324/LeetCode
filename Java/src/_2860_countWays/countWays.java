package _2860_countWays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class countWays {
    public static void main(String[] args) {
        System.out.println(new Solution().countWays(new ArrayList<Integer>(){{
            add(1);
            add(1);
        }}));
    }
}

class Solution {
    public int countWays(List<Integer> nums) {
        int n = nums.size();
        int res = 0;
        Collections.sort(nums);
        for (int i = 0; i <= n; i++) {
//          这位学生被选中，并且被选中的学生人数 严格大于 nums[i]
            if (i > 0 && nums.get(i - 1) >= i) {
                continue;
            }
//          这位学生没有被选中，并且被选中的学生人数 严格小于 nums[i]
            if (i < n && nums.get(i) <= i) {
                continue;
            }
            res++;
        }
        return res;
    }
}