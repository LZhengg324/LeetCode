package _3206_numberOfAlternatingGroups;

public class _3206_numberOfAlternatingGroups {
}

class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] == colors[(i + 2) % n] && colors[i] != colors[(i + 1) % n]) {
                res += 1;
            }
        }
        return res;
    }
}
