package _151_reverseWords;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _151_reverseWords {
}

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> wordList = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}