package _50_myPow;

public class _50_myPow {
    public static void main(String[] args) {
        System.out.println(new Solution2().myPow(2.1, 3));
    }
}

//快速幂 = 通过乘法实现幂运算
class Solution {
    public double myPow(double x, int n) {  //快速幂+递归
        long nn = (long)n ;
        return nn >= 0 ? quickMul(x, nn) : 1.0 / quickMul(x, -nn);
    }

    private double quickMul(double x, long nn) {
        if (nn == 0) {
            return 1;
        }
        double y = quickMul(x, nn / 2);
        return nn % 2 == 0 ? y * y : y * y * x;
    }
}

class Solution2 {   //快速幂 + 迭代
    public double myPow(double x, int n) {
        long nn = (long)n ;
        return nn >= 0 ? quickMul(x, nn) : 1.0 / quickMul(x, -nn);
    }

    private double quickMul(double x, long nn) {
        double ans = 1;
        double x_contribution = x;
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans *= x_contribution;
            }
            x_contribution *= x_contribution;
            nn /= 2;
        }
        return ans;
    }
}