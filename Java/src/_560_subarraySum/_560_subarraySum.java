package _560_subarraySum;

import java.util.HashMap;

public class _560_subarraySum {
    public static void main(String[] args) {

    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0, pre = 0;
        HashMap<Integer, Integer> rec = new HashMap<Integer, Integer>(){{put(0, 1);}};
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (rec.containsKey(pre - k)) {
                ans += rec.get(pre - k);
            }
            rec.put(pre, rec.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}