package _1974_minTimeToType;

public class minTimeToType {
    public static void main(String[] args) {

    }
}

class Solution {
    public int minTimeToType(String word) {
        int sec = word.length();
        char[] chars = word.toCharArray();
        char pre = 'a';
        for (int i = 0; i < word.length(); i++) {
            int step = Math.abs(chars[i] - pre);
            sec += Math.min(step, 26 - step);
            pre = chars[i];
        }
        return sec;
    }
}
