from math import inf
from functools import cache
from typing import List


class Solution:
    def maximumSum(self, arr: List[int]) -> int:
        @cache  # 可实现记忆化搜索
        def dfs(i: int, j: int) -> int:
            if i < 0:
                return -inf
            if j == 0:  # 不删除
                return max(dfs(i - 1, 0), 0) + arr[i]
            else:  # 删除
                return max(dfs(i - 1, 0), dfs(i - 1, 1) + arr[i])

        return max(max(dfs(i, 0), dfs(i, 1)) for i in range(len(arr)))


class Solution2:
    def maximumSum(self, arr: List[int]) -> int:
        dp0, dp1 = arr[0], 0    # dp0表示不删除，dp1表示删除
        ans = arr[0]
        for i in range(1, len(arr)):
            dp1 = max(dp0, dp1 + arr[i])
            dp0 = max(dp0, 0) + arr[i]
            ans = max(ans, max(dp0, dp1))
        return ans


print(Solution2().maximumSum([1, -2, -2, 3]))
