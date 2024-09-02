from functools import cache

MOD = int(10e8 + 7)
#
#
# # 记忆化搜索
# @cache
# def dfs(i: int, j: int, k: int) -> int:
#     """
#     记忆化搜索
#     :param i: 长度为i的字符串
#     :param j: 在长度为i的字符串已有j个'A'
#     :param k: 在长度为i的字符串已有连续k个'L'
#     :return: 长度为i的字符串有多少个合法给予奖励的情况
#     """
#     if i == 0:
#         return 1
#     res = dfs(i - 1, j, 0)  # 填'P', 连续L的次数清0
#     if j < 1:
#         res += dfs(i - 1, 1, 0)  # 填'A', 连续L的次数清0
#     if k < 2:
#         res += dfs(i - 1, j, k + 1)  # 填'L', 连续L的次数+1
#     return res % MOD


# class Solution:
#     def checkRecord(self, n: int) -> int:
#         return dfs(n, 0, 0)


# 动态规划（递推）
class Solution:
    def checkRecord(self, n: int) -> int:
        dp = [[[0] * 3, [0] * 3] for _ in range(n + 1)]
        # dp[i][j][k] 为第i个字符时，j个'A'，和连续k个'L'的合法给予奖励的情况
        dp[0][0][0] = 1

        for i in range(1, n + 1):
            # 以'P'为字符串结尾
            for j in range(2):
                for k in range(3):
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD

            # 以'A'为字符串结尾
            for k in range(3):
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD

            # 以'L'为字符串结尾
            for j in range(2):
                for k in range(1, 3):
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD

        total = 0
        for j in range(2):
            for k in range(3):
                total += dp[n][j][k]
        return total % MOD


if __name__ == '__main__':
    print(Solution().checkRecord(10101))
