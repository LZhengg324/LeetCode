package _3174_clearDigits;

import java.util.Arrays;

public class clearDigits {
    public static void main(String[] args) {

    }
}

class Solution {
    public String clearDigits(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] marked = new int[len];
        Arrays.fill(marked, 1);
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(chars[i])) {
                for (int j = i - 1; j >= 0; j--) {
                    if (Character.isLetter(chars[j]) && marked[j] == 1) {
                        marked[j] = 0;
                        break;
                    }
                }
                marked[i] = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (marked[i] == 1) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}

class Solution2 {   //栈模拟
    public String clearDigits(String s) {
        int len = s.length();
        char[] stack = new char[len];
        int sp = -1;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                sp--;
                continue;
            }
            stack[++sp] = s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= sp; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }
}