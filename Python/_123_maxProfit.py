from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        c = [0]
        buy = prices[0]
        for i in range(1, n):
            if prices[i] > prices[i - 1]:
                c.pop()
                c.append(prices[i] - buy)
            else :
                buy = prices[i]
                c.append(0)
        if len(c) == 1:
            return c[0]
        max1 = 0
        max2 = 0
        for i in range(len(c)):
            if c[i] > max1:
                max2 = max1
                max1 = c[i]
            elif c[i] > max2:
                max2 = c[i]
        return max1 + max2

if __name__ == '__main__':
    print(Solution().maxProfit([1, 4, 2]))
