package _3164_numberOfPairs;

import java.util.HashMap;

public class _3164_numberOfPairs {
}

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        HashMap<Integer, Integer> cnt1 = new HashMap<>();
        HashMap<Integer, Integer> cnt2 = new HashMap<>();
        int max1 = Integer.MIN_VALUE;
        for (int num : nums1) {
            if (num % k == 0) {
                cnt1.put(num / k, cnt1.getOrDefault(num / k, 0) + 1);
                max1 = Math.max(max1, num);
            }
        }
        if (cnt1.isEmpty()) {
            return 0;
        }
        for (int num : nums2) {
            cnt2.put(num, cnt2.getOrDefault(num, 0) + 1);
        }
        long res = 0;
        for (int b : cnt2.keySet()) {
            for (int a = b; a <= max1; a += b) {
                if (cnt1.containsKey(a)) {
                    res += 1L * cnt1.get(a) * cnt2.get(b);
                }
            }
        }
        return res;
    }
}