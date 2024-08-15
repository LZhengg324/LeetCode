from typing import List


# 经典BFS
class Solution:
    def getFood(self, grid: List[List[str]]) -> int:
        rows, cols = len(grid), len(grid[0])
        # 找起点
        start = (0, 0)
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '*':
                    start = (i, j)
                    break
        q = [start]
        visited = [[False for _ in range(cols)] for _ in range(rows)]   # 记录是否已访问
        visited[start[0]][start[1]] = True
        step = 0
        while q:
            cur_len = len(q)
            step += 1
            for _ in range(cur_len):
                cur = q.pop(0)
                for x, y in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                    nx, ny = cur[0] + x, cur[1] + y
                    if 0 <= nx < rows and 0 <= ny < cols:
                        if grid[nx][ny] == "#":
                            return step
                        elif not visited[nx][ny] and grid[nx][ny] == 'O':
                            q.append((nx, ny))
                            visited[nx][ny] = True
        return -1


if __name__ == '__main__':
    print(Solution().getFood([["X", "X", "X", "X", "X", "X"],
                              ["X", "*", "O", "O", "O", "X"],
                              ["X", "O", "O", "#", "O", "X"],
                              ["X", "X", "X", "X", "X", "X"]]))
