package _131_partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _131_partition {
}

class Solution {
    boolean[][] f = new boolean[16][16];
    List<List<String>> res = new ArrayList<>();
    List<String> comb = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int n = s.length();
        for (boolean[] ff : f) {
            Arrays.fill(ff, true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j) && f[i + 1][j - 1]);
            }
        }
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int i) {
        if (i == s.length()) {
            res.add(new ArrayList<String>(comb));
        }
        for (int j = i; j < s.length(); j++) {
            if (f[i][j]) {
                comb.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                comb.remove(comb.size() - 1);
            }
        }
    }
}