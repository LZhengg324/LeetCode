package _7_reverse;

public class _7_reverse {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(new Solution().reverse(2047473312));
    }
}

class Solution {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (ret > 214748364 || (ret == 214748364 && tmp > 7)) {
                return 0;
            }
            if (ret < -214748364 || (ret == -214748364 && tmp < -8)) {
                return 0;
            }
            ret = ret * 10 + tmp;
            x /= 10;
        }
        return ret;
    }
}
