package _482_licenseKeyFormatting;

public class _482_licenseKeyFormatting {
}

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        s = s.replaceAll("-", "");
        int i = s.length();
        int f = 0;
        while (i > 0) {
            if (f == k) {
                f = 0;
                sb.append('-');
            }
            sb.append(Character.toUpperCase(s.charAt(--i)));
            f++;
        }
        return sb.reverse().toString();
    }
}