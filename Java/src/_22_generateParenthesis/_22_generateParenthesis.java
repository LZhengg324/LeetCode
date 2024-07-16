package _22_generateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class _22_generateParenthesis {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void dfs(List<String> ans, StringBuilder sb, int open, int closed, int n) {
        if (open + closed == n * 2) {
            ans.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            dfs(ans, sb, open + 1, closed, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closed < open) {
            sb.append(')');
            dfs(ans, sb, open, closed + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
