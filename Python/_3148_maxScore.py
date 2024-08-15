from math import inf
from typing import List


class Solution:
    def maxScore(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        col_pre = [-inf] * n
        ans = -inf
        for i in range(m):
            row_pre = -inf
            for j in range(n):
                f = -inf
                # 从上面来
                if i > 0:
                    f = max(f, grid[i][j] + col_pre[j])
                # 从左边来
                if j > 0:
                    f = max(f, grid[i][j] + row_pre)
                # 记录最大值
                ans = max(ans, f)
                # 更新j列可获得最大分数
                col_pre[j] = max(col_pre[j], max(f, 0) - grid[i][j])
                # 更新i行可获得的最大分数
                row_pre = max(row_pre, max(f, 0) - grid[i][j])
        return ans
