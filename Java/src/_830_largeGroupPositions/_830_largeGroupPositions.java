package _830_largeGroupPositions;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class _830_largeGroupPositions {
    public static void main(String[] args) {
    }
}

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] str = s.toCharArray();
        List<List<Integer>> res = new ArrayList<>();
        int n = s.length();
        int l = 0, r = 0;
        while (r < n) {
            while (r < n - 1 && str[r + 1] == str[r]) {
                r += 1;
            }
            if (r - l >= 2) {
                res.add(Arrays.asList(l, r));
            }
            r += 1;
            l = r;
        }
        return res;
    }
}