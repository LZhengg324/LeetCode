package _2931_maxSpending;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _2931_maxSpending {
}

class Solution {
    public long maxSpending(int[][] values) {
        int m = values.length, n = values[0].length;
        int[] next = new int[m];
        Arrays.fill(next, n - 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> values[o][next[o]]));
        for (int i = 0; i < m; i++) {
            pq.offer(i);
        }
        long res = 0;
        for (int i = 1; i < m * n + 1; i++) {
            int shop = pq.poll();
            res += (long)values[shop][next[shop]] * i;
            if (next[shop] > 0) {
                next[shop]--;
                pq.offer(shop);
            }
        }
        return res;
    }
}