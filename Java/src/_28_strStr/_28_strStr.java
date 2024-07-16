package _28_strStr;

public class _28_strStr {
    public static void main(String[] args) {
        System.out.println(new Solution2().strStr("abababc", "ababc"));
    }
}

class Solution {    //作弊
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

class Solution2 {   //KMP算法
    public int strStr(String haystack, String needle) {
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int[] next = buildNext(needle);
        int i = 0, j = 0;
//        System.out.println(Arrays.toString(next));
        while (i < s.length) {
            if (s[i] == p[j]) {
                i += 1;
                j += 1;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i += 1;
            }

            if (j == p.length) {
                return i - j;
            }
        }
        return -1;
    }

    private int[] buildNext(String s) {
        int i = 1;
        int same_prefix = 0;
        char[] patt = s.toCharArray();
        int[] next = new int[patt.length];
        while (i < patt.length) {
            if (patt[same_prefix] == patt[i]) {
                same_prefix += 1;
                next[i] = same_prefix;
                i += 1;
            } else {
                if (same_prefix == 0) {
                    next[i] = 0;
                    i += 1;
                } else {
                    same_prefix = next[same_prefix - 1];
                }
            }
        }
        return next;
    }
}

