package _3226_minChanges;

public class _3226_minChanges {
}

class Solution {
    public int minChanges(int n, int k) {
        if ((~n & k) != 0) {
            return -1;
        }
        int t = n & ~k;
        int res = 0;
        while (t != 0) {
            res += (t & 1);
            t >>= 1;
        }
        return res;
    }
}