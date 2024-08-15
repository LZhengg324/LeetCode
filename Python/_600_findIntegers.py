from typing import Optional


class Solution:
    def findIntegers(self, n: int) -> int:
        dp = [0] * 31
        dp[0] = dp[1] = 1
        for i in range(2, 31):
            dp[i] = dp[i-1] + dp[i-2]
        pre = 0
        ans = 0
        for i in range(29, -1, -1):
            val = (1 << i)
            if n & val:
                ans += dp[i + 1]
                if pre:
                    break
                pre = 1
            else:
                pre = 0
            if i == 0:
                ans += 1
        return ans


if __name__ == '__main__':
    print(Solution().findIntegers(100000000))