package _29_divide;

public class _29_divide {
    public static void main(String[] args) {
        System.out.println(new Solution().divide(-3245678, -32));
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        //考虑dividend最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        //考虑divisor为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        //记录正负数
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }
        return rev ? -div(dividend, divisor) : div(dividend, divisor);
    }

    private int div(int a, int b) {
        if (a > b) {
            return 0;
        }
        int ret = 1;
        int step = b;
        while (a - step <= step) {
            step += step;
            ret += ret;
        }
        return ret + div(a - step, b);
    }
}
