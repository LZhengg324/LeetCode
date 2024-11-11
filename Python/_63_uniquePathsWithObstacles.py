from functools import cache
from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        @cache
        def dfs(i: int, j: int) -> int:
            if obstacleGrid[i][j]:
                return 0
            cnt = 0
            if i == m - 1 and j == n - 1:
                return 1
            if i < m - 1:
                cnt += dfs(i + 1, j)
            if j < n - 1:
                cnt += dfs(i, j + 1)
            return cnt
        return dfs(0, 0)

if __name__ == '__main__':
    print(100000 * (100001) / 2)