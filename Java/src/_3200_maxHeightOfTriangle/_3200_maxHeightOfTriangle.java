package _3200_maxHeightOfTriangle;

public class _3200_maxHeightOfTriangle {
}

class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(build(red, blue), build(blue, red));
    }

    private int build(int red, int blue) {
        int cnt = 1;
        while (true) {
            if (red < cnt) {
                return cnt - 1;
            }
            red -= cnt++;
            if (blue < cnt) {
                return cnt - 1;
            }
            blue -= cnt++;
        }
    }
}