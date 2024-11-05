package _1167_connectSticks;

import java.util.PriorityQueue;

public class connectSticks {
}

class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int stick : sticks) {
            heap.add(stick);
        }
        int res = 0;
        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();
            res += x + y;
            heap.add(x + y);
        }
        return res;
    }
}