package _2288_discountPrices;

public class _2288_discountPrices {
    public static void main(String[] args) {
        System.out.println(
                new Solution().discountPrices("there are $1 $2 and 5$ candies in the shop", 10)
        );
    }
}

class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].charAt(0) == '$' && isCost(strs[i])) {
                double cost = Double.parseDouble(strs[i].substring(1));
                strs[i] = String.format("$%.2f", cost * (1 - discount / 100.0));
            }
        }
        return String.join(" ", strs);
    }

    private boolean isCost(String s) {
        if (s.length() <= 1) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}