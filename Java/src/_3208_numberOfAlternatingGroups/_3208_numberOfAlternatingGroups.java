package _3208_numberOfAlternatingGroups;

public class _3208_numberOfAlternatingGroups {
}

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int l = 0, r = 0;
        int res = 0;
        while (true) {
            if (colors[(r + n) % n] != colors[(r + 1 + n) % n]) {
                r += 1;
                if (r - l + 1 > k) {
                    l += 1;
                }
            } else {
                l = r + 1;
                r = r + 1;
            }
            if (l >= n) {
                break;
            }
            if (r - l + 1 == k) {
                res += 1;
            }
        }
        return res;
    }
}