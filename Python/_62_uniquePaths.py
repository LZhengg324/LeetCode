from math import comb


class Solution1:
    __choices = 0

    def uniquePaths(self, m: int, n: int) -> int:
        def dfs(i: int, j: int):
            if i >= m or j >= n:
                return
            if i == m - 1 and j == n - 1:
                self.__choices += 1
                return
            dfs(i, j + 1)
            dfs(i + 1, j)

        dfs(0, 0)
        return self.__choices


class Solution2:    # 动态规划
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[1] * n] * m
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        # print(dp)
        return dp[m - 1][n - 1]


class Solution3:    # 组合
    def uniquePaths(self, m: int, n: int) -> int:
        return comb(m + n - 2, n - 1)


class Solution4:    # 组合(手打)
    def uniquePaths(self, m: int, n: int) -> int:
        def factorial(n: int) -> int:
            return 1 if n <= 1 else n * factorial(n - 1)
        y = factorial(m + n - 2)
        x = factorial(m - 1) * factorial(n - 1)
        return y // x


if __name__ == '__main__':
    print(Solution4().uniquePaths(3, 7))
