package _1003_isValid;

public class _1003_isValid {
}

class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            stack[++top] = s.charAt(i);
            if (top >= 2 && stack[top] == 'c' && stack[top - 1] == 'b' && stack[top - 2] == 'a') {
                top -= 3;
            }
        }
        return top == -1;
    }
}