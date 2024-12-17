package _93_restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

public class _93_restoreIpAddresses {
}

class Solution {

    static final int SEG = 4;
    List<String> res = new ArrayList<String>();
    int[] segments = new int[SEG];

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return res;
    }

    public void dfs(String s, int seg_cur, int index) {
        if (seg_cur == SEG) {
            if (index == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEG - 1; i++) {
                    sb.append(String.valueOf(segments[i])).append(".");
                }
                sb.append(String.valueOf(segments[SEG - 1]));
                res.add(sb.toString());
            }
            return;
        }
        if (index == s.length()) {
            return;
        }
        if (s.charAt(index) == '0') {
            segments[seg_cur] = 0;
            dfs(s, seg_cur + 1, index + 1);
        } else {
            int addr = 0;
            for (int index_end = index; index_end < s.length(); index_end++) {
                addr = addr * 10 + (s.charAt(index_end) - '0');
                if (addr > 0 && addr <= 255) {
                    segments[seg_cur] = addr;
                    dfs(s, seg_cur + 1, index_end + 1);
                } else {
                    break;
                }
            }
        }
    }
}