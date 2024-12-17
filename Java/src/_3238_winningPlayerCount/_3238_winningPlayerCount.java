package _3238_winningPlayerCount;

public class _3238_winningPlayerCount {
}

class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] counter = new int[n][11];
        for (int[] p : pick) {
            counter[p[0]][p[1]]++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                if (i < counter[i][j]) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}