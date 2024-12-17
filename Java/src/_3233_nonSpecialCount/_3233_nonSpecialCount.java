package _3233_nonSpecialCount;

public class _3233_nonSpecialCount {
}

class Solution {
    public int nonSpecialCount(int l, int r) {
        int n = (int)Math.sqrt(r);
        int res = r - l + 1;
        int[] notPrime = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (notPrime[i] == 0) {
                if (i * i >= l && i * i <= r) {
                    res -= 1;
                }
                for (int j = i * 2; j <= n; j += i) {
                    notPrime[j] = 1;
                }
            }
        }
        return res;
    }
}