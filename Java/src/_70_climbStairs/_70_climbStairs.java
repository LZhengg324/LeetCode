package _70_climbStairs;

public class _70_climbStairs {
    public static void main(String[] args) {

    }
}

class Solution {
    public int climbStairs(int n) {
        int n1 = 0, n2 = 0;
        int n3 = 1;
        while (n-- > 0) {
            n1 = n2;
            n2 = n3;
            n3 = n1 + n2;
        }
        return n3;
    }
}