package _20_isValid;

import java.util.Stack;

public class _20_isValid {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("({{{{}}})"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()){
                    return false;
                } else {
                    if (c - stack.peek() != 2 && c - stack.peek() != 1) {
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}