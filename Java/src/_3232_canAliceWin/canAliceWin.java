package _3232_canAliceWin;

public class canAliceWin {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canAliceWin(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            if (num > 9) {
                a += num;
            } else {
                b += num;
            }
        }
        return a != b;
    }
}