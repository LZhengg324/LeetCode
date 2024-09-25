from typing import List


class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        dp = [[-1] * 51 for _ in range(n)]
        res = 0

        for i in range(n):
            dp[i][0] = 1
            for l in range(k + 1):
                for j in range(i):
                    add = 1 if nums[i] != nums[j] else 0
                    if l - add >= 0 and dp[j][l - add] != -1:
                        dp[i][l] = max(dp[i][l], dp[j][l - add] + 1)
                res = max(res, dp[i][l])

        return res