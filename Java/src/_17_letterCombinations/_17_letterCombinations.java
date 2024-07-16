package _17_letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_letterCombinations {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("234"));
    }
}

class Solution {
    private final HashMap<Character, String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (!digits.isEmpty()) {
            dfs(list, digits, 0, sb);
        }
        return list;
    }

    private void dfs(List<String> list, String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }
        String possible = map.get(digits.charAt(index));
        for (int i = 0; i < possible.length(); i++) {
            sb.append(possible.charAt(i));
            dfs(list, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}