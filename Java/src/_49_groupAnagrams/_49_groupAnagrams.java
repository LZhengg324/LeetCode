package _49_groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _49_groupAnagrams {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> dict = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String key = new String(str);
            if (!dict.containsKey(key)) {
                dict.put(key, new ArrayList<String>());
            }
            dict.get(key).add(strs[i]);
        }
        return new ArrayList<List<String>>(dict.values());
    }
}