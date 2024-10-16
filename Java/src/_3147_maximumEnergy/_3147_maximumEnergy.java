package _3147_maximumEnergy;

public class _3147_maximumEnergy {
}

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int[] map = new int[k];
        int res = Integer.MIN_VALUE;
        for (int i = energy.length - 1; i >= 0; i--) {
            res = Math.max(map[i % k] + energy[i], res);
            map[i % k] += energy[i];
        }
        return res;
    }
}