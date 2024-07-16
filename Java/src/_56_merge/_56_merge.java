package _56_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56_merge {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int p1 = 0;
        while (p1 < intervals.length) {
            int p2 = p1 + 1;
            int start = intervals[p1][0];
            int end = intervals[p1][1];
            while (p2 < intervals.length && end >= intervals[p2][0]) {
                end = Math.max(intervals[p2][1], end);
                p2++;
            }
            list.add(new int[]{start, end});
            p1 = p2;
        }
        return list.toArray(new int[list.size()][]);
    }
}