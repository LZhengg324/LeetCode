package _LCP61_temperatureTrend;

public class _LCP61_temperatureTrend {
    public static void main(String[] args) {
        System.out.println(new Solution().temperatureTrend(new int[]{5,10,16,-6,15,11,3}, new int[]{16,22,23,23,25,3,-16}));
    }
}

class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int days = temperatureA.length;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 1; i < days; i++) {
            if ((temperatureA[i] - temperatureA[i - 1] < 0 && temperatureB[i] - temperatureB[i - 1] < 0) ||
                    (temperatureA[i] - temperatureA[i - 1] == temperatureB[i] - temperatureB[i - 1]) ||
                    (temperatureA[i] - temperatureA[i - 1] > 0 && temperatureB[i] - temperatureB[i - 1] > 0)) {
                cur++;
            } else {
                cur = 0;
            }
            max = Math.max(cur, max);
        }
        return max;
    }
}