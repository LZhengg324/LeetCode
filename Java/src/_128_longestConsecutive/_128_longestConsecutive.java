package _128_longestConsecutive;

import java.util.HashSet;

public class _128_longestConsecutive {
    public static void main(String[] args) {

    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int longestStreak = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int currentStreak = 1;
                while (set.contains(n + 1)) {
                    currentStreak++;
                    n++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}