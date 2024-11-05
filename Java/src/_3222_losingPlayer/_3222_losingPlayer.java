package _3222_losingPlayer;

public class _3222_losingPlayer {
}

class Solution {
    public String losingPlayer(int x, int y) {
        int opr = Math.min(x, y / 4);
        return opr % 2 == 0 ? "Bob" : "Alice";
    }
}