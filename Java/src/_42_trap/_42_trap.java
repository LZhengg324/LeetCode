package _42_trap;

import java.util.ArrayDeque;

public class _42_trap {
    public static void main(String[] args) {

    }
}

class Solution {
    public int trap(int[] height) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                ret += (Math.min(height[i], height[left]) - height[top]) * (i - left - 1);
            }
            stack.push(i);
        }
        return ret;
    }
}