package _2806_accountBalanceAfterPurchase;

public class _2806_accountBalanceAfterPurchase {
    public static void main(String[] args) {
        System.out.println(new Solution().accountBalanceAfterPurchase(11));
    }
}

class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - (purchaseAmount + 5) / 10 * 10;
    }
}