package _452_findMinArrowShots;

import java.util.Arrays;
import java.util.Comparator;

public class _452_findMinArrowShots {
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                if (p1[1] < p2[1]) {
                    return -1;
                } else if (p1[1] > p2[1]) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int res = 1;
        int pos = points[0][1];
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                res++;
                pos = balloon[1];
            }
        }
        return res;
    }
}