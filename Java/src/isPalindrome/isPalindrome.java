package isPalindrome;

public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(10));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        String s = ((Integer)x).toString();
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}