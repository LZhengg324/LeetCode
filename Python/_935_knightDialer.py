from functools import cache

class Solution:
    def knightDialer(self, n: int) -> int:
        MOD = 10 ** 9 + 7
        NEXT = (4, 6), (6, 8), (7, 9), (4, 8), (0, 3, 9), (), (0, 1, 7), (2, 6), (1, 3), (2, 4)

        @cache
        def dfs(i: int, j: int) -> int:
            """
            记忆化搜索
            :param i: 还要走 k 次
            :param j: 当前在 j 位置
            :return: 当前在 j 位置，还需走 i 次有多少种组合
            """
            if i == 0:
                return 1
            return sum(dfs(i - 1, k) for k in NEXT[j])

        if n == 1:
            return 10
        return sum(dfs(n - 1, j) for j in range(10))


