package _296_minTotalDistance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _296_minTotalDistance {

}

class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        int row_mid = rows.get(rows.size() / 2);
        Collections.sort(cols);
        int col_mid = cols.get(cols.size() / 2);

        return minDist(rows, row_mid) + minDist(cols, col_mid);
    }

    private int minDist(List<Integer> points, int mid) {
        int dis = 0;
        for (Integer point : points) {
            dis += Math.abs(point - mid);
        }
        return dis;
    }
}