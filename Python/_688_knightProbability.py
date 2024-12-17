from functools import cache

class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        directions = (1, 2), (-1, 2), (1, -2), (-1, -2), (2, 1), (-2, 1), (2, -1), (-2, -1)
        @cache
        def dfs(k: int, i: int, j: int) -> float:
            """
            记忆化搜索
            马走了k步后还在棋盘上的概率
            :param k: 还剩 k 步
            :param i: 马当前行坐标
            :param j: 马当前列坐标
            :return: 走了 k 步之后还在棋盘上的概率
            """
            if not (0 <= i < n and 0 <= j < n):
                return 0
            if k == 0:
                return 1
            cnt = 0
            for dx, dy in directions:
                cnt += dfs(k - 1, i + dx, j + dy) / 8
            return cnt
        return dfs(k, row, column)


