from typing import List
from functools import cache
from math import inf

# 记忆化搜索
class Solution1:
    def minCost(self, n: int, cuts: List[int]) -> int:
        wood = [0] + cuts + [n]
        wood.sort()

        @cache
        def dfs(i: int, j: int) -> int:
            if i + 1 == j:
                return 0
            res = inf
            for k in range(i + 1, j):
                res = min(res, dfs(i, k) + dfs(k, j))
            return res + wood[j] - wood[i]

        return dfs(0, len(wood) - 1)

# 动态规划递推
class Solution2:
    def minCost(self, n: int, cuts: List[int]) -> int:
        wood = [0] + cuts + [n]
        wood.sort()
        dp = [[0] * len(wood) for _ in range(len(wood))]
        for i in range(len(wood) - 3, -1, -1):
            for j in range(i + 2, len(wood)):
                res = inf
                for k in range(i + 1, j):
                    res = min(res, dp[i][k] + dp[k][j])
                dp[i][j] = res + wood[j] - wood[i]
        return dp[0][len(wood) - 1]
