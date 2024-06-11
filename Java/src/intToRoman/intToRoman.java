package intToRoman;

public class intToRoman {
    public static void main(String[] args) {
        System.out.println(new Solution2().intToRoman(70));
    }
}

class Solution1 {   //暴力枚举
    public String intToRoman(int num) {
        String[] s = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(s[i]);
            }
        }
        return sb.toString();
    }
}

class Solution2 {   //硬编码
    public String intToRoman(int num) {
        String[] thousands = new String[]{"", "M", "MM", "MMM"};   //1000, 2000, 3000
        String[] hundreds = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};   //100 ~ 900
        String[] tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};   //10 ~ 90
        String[] ones = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", }; //1 ~ 9
        StringBuilder sb = new StringBuilder();
        sb.append(thousands[num / 1000]);
        sb.append(hundreds[num % 1000 / 100]);
        sb.append(tens[num % 100 / 10]);
        sb.append(ones[num % 10]);
        return sb.toString();
    }
}
