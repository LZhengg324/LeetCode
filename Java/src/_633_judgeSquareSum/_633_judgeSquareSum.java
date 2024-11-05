package _633_judgeSquareSum;

public class _633_judgeSquareSum {
}

class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            if (left * left == c - right * right) {
                return true;
            } else if (left * left > c - right * right) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return false;
    }
}