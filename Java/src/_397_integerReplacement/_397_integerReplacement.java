package _397_integerReplacement;

import java.util.HashMap;
import java.util.Map;

public class _397_integerReplacement {
}

class Solution {
    Map<Long, Integer> memo = new HashMap<Long, Integer>();
    public int integerReplacement(int n) {
        return dfs(n * 1L);
    }

    private int dfs(long n) {
        if (n == 1) {
            return 0;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int ans = 0;
        if (n % 2 == 0) {
            ans = dfs(n / 2) + 1;
        } else {
            ans = Math.min(dfs(n - 1), dfs(n + 1)) + 1;
        }
        memo.put(n, ans);
        return ans;
    }
}