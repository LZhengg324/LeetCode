package _2748_countBeautifulPairs;

public class _2748_countBeautifulPairs {
    public static void main(String[] args) {
        System.out.println(new Solution().countBeautifulPairs(new int[]{11,21,12}));
    }
}

class Solution {
    public int countBeautifulPairs(int[] nums) {
        int[] front = new int[10];
        int ret = 0;
        for (int num : nums) {
            for (int i = 1; i < 10; i++) {
                if (gcd(i, num % 10) == 1) {     //互质：两个整数公约数只有1
                    ret += front[i];
                }
            }
            while (num >= 10) {
                num /= 10;
            }
            front[num]++;
        }
        return ret;
    }

    private int gcd(int a, int b) {
        int c = 0;
        while (a % b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return b;
    }
}