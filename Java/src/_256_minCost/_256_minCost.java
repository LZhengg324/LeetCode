package _256_minCost;

public class _256_minCost {
}

class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int red = costs[0][0], blue = costs[0][1], green = costs[0][2];
        for (int i = 1; i < n; i++) {
            int nextRed = Math.min(blue, green) + costs[i][0];
            int nextBlue = Math.min(red, green) + costs[i][1];
            int nextGreen = Math.min(red, blue) + costs[i][2];
            red = nextRed;
            blue = nextBlue;
            green = nextGreen;
        }
        return Math.min(red, Math.min(blue, green));
    }
}