from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        # 动态规划，dp[i][0]表示在第i天不持有股票的收益，dp[i][1]表示在第i天持有一只股票的收益
        # dp = [[0] * 2] * n
        # dp[0][0] = 0
        # dp[0][1] = -prices[0]
        # for i in range(1, n):
        #     dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])  # 不买/卖
        #     dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])  # 不卖/买
        # return max(dp[n - 1][0], dp[n - 1][1])

        # 优化：因状态转移方程仅和上一个有关
        dp0 = 0  # 不持有股票
        dp1 = -prices[0]  # 持有股票
        for i in range(1, n):
            newDp0 = max(dp0, dp1 + prices[i])  # 不买/卖
            newDp1 = max(dp1, dp0 - prices[i])  # 不卖/买
            dp0 = newDp0
            dp1 = newDp1
        return max(dp0, dp1)


class Solution2:    # 贪心
    def maxProfit(self, prices: List[int]) -> int:
        ans = 0
        for i in range(1, len(prices)):
            ans += max(prices[i] - prices[i - 1], 0)
        return ans


if __name__ == '__main__':
    print(Solution().maxProfit([7, 1, 3, 5, 6, 4]))
