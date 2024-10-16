package _1884_twoEggDrop;

public class _1884_twoEggDrop {
}

class Solution {
    public int twoEggDrop(int n) {
        return (int)Math.ceil((-1 + Math.sqrt(1 + 8 * n)) / 2);
    }
}