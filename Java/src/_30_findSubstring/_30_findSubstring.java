package _30_findSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _30_findSubstring {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int sLen = s.length(), wordLen = words[0].length(), wordsLen = words.length;
        for (int i = 0; i < wordLen; i++) {
            if (i + wordLen * wordsLen > s.length()) {
                break;
            }
            HashMap<String, Integer> differ = new HashMap<>();
            //统计words中的单词
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            //左右边界的下标
            int left = i, right = i;
            //当前匹配上的单词数量
            int curCount = 0;
            while (right <= s.length() - wordLen) {
                String sWord = s.substring(right, right + wordLen);
                int cnt = differ.getOrDefault(sWord, 0);
                if (cnt > 0) {
                    curCount++;
                    differ.put(sWord, cnt - 1);
                    right += wordLen;
                    if (curCount == wordsLen) {
                        list.add(left);
                    }
                } else {
                    if (curCount > 0) {
                        String throwWord = s.substring(left, left + wordLen);
                        differ.put(throwWord, differ.get(throwWord) + 1);
                        left += wordLen;
                        curCount--;
                    } else {
                        left += wordLen;
                        right += wordLen;
                    }
                }
            }
        }
        return list;
    }
}