from typing import List


class Solution:
    def minFlips(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        row, col = 0, 0
        # 行的
        for i in range(m):
            for j in range(n // 2 - 1, -1, -1):
                if grid[i][j] ^ grid[i][n - j - 1]:
                    row += 1

        # 列的
        for j in range(n):
            for i in range(m // 2 - 1, -1, -1):
                if grid[i][j] ^ grid[m - i - 1][j]:
                    col += 1

        return min(row, col)
