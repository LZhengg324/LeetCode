package _521_findLUSlength;

public class _521_findLUSlength {
    public static void main(String[] args) {

    }
}

class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}