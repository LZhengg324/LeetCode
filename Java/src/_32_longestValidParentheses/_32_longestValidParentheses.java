package _32_longestValidParentheses;

import java.util.ArrayDeque;

public class _32_longestValidParentheses {
    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses(")()())"));
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(); //存放下标
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                stack.poll();
                if (!stack.isEmpty()) {
                    max = Math.max(i - stack.getFirst(), max);
                } else {
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
        }
        return max;
    }
}