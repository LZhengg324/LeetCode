from typing import List


class Solution:
    def numberOfRightTriangles(self, grid: List[List[int]]) -> int:
        row = [0 for _ in range(len(grid))]
        col = [0 for _ in range(len(grid[0]))]
        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    row[i] += 1
                    col[j] += 1
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    ans += (row[i] - 1) * (col[j] - 1)
        return ans


if __name__ == '__main__':
    print(Solution().numberOfRightTriangles([[1, 0, 1], [1, 0, 0], [1, 0, 0]]))
