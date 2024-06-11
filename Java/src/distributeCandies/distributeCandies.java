package distributeCandies;

public class distributeCandies {
    public static void main(String[] args) {
        System.out.println(new Solution2().distributeCandies(5, 1));
    }
}

class Solution1 {   //三重循环
    public int distributeCandies(int n, int limit) {
        int cal = 0;
        for (int i = 0; i <= limit; i++) {
            if (i > n) break;
            for (int j = 0; j <= limit; j++) {
                if (i + j > n) break;
                for (int k = 0; k <= limit; k++) {
                    if (i + j + k > n) break;
                    if (i + j + k == n) {
                        cal++;
                    }
                }
            }
        }
        return cal;
    }
}

class Solution2 {   //排列与组合
    public int distributeCandies(int n, int limit) {
        //全情况 +2为两片木板
        int all = cal(n + 2);
        //至少一个拿到超过limit数量的糖果 +2为两边木板
        int one = 3 * cal(n - (limit + 1) + 2);
        //至少两个拿到超过limit数量的糖果 +2为两片木板
        int two = 3 * cal(n - 2 * (limit + 1) + 2);
        //至少三个拿到超过limit数量的糖果 +2为两片木板
        int three = cal (n - 3 * (limit + 1) + 2);
        return all - one + two - three;
    }

    private int cal(int x) {
        if (x < 1) return 0;
        return x * (x - 1) / 2;
    }
}