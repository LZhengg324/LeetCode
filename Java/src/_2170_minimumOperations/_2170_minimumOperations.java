package _2170_minimumOperations;

import java.util.HashMap;

public class _2170_minimumOperations {
}

class Solution {
    public int minimumOperations(int[] nums) {
        int[] oddCounter = count(0, nums);
        int[] evenCounter = count(1, nums);

        if (oddCounter[0] != evenCounter[0]) {
            return nums.length - oddCounter[1] - evenCounter[1];
        } else {
            return nums.length - Math.max(oddCounter[1] + evenCounter[3], oddCounter[3] + evenCounter[1]);
        }
    }

    private int[] count(int start, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < nums.length; i += 2) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int firstKey = 0, firstValue = 0, secondKey = 0, secondValue = 0;
        for (Integer key: map.keySet()) {
            if (map.get(key) > firstValue) {
                secondKey = firstKey;
                secondValue = firstValue;
                firstKey = key;
                firstValue = map.get(key);
            } else if (map.get(key) > secondValue) {
                secondKey = key;
                secondValue = map.get(key);
            }
        }
        return new int[]{firstKey, firstValue, secondKey, secondValue};
    }
}