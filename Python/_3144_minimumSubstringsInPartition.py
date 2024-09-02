from collections import defaultdict
from functools import cache
from math import inf


# 记忆化搜索版本
class Solution:
    def minimumSubstringsInPartition(self, s: str) -> int:
        @cache
        def dfs(index: int) -> int:
            if index < 0:
                return 0
            mp = defaultdict(int)
            max_cnt = 0
            res = inf
            for i in range(index, -1, -1):
                mp[s[i]] += 1
                max_cnt = max(max_cnt, mp[s[i]])
                if index - i + 1 == len(mp) * max_cnt:
                    res = min(res, dfs(i - 1) + 1)
            return res

        return dfs(len(s) - 1)


# 递推版本
class Solution2:
    def minimumSubstringsInPartition(self, s: str) -> int:
        n = len(s)
        dp = [inf] * (n + 1)
        dp[0] = 0
        mp = defaultdict(int)
        for i in range(1, n + 1):
            mp.clear()
            max_cnt = 0
            for j in range(i, 0, -1):
                mp[s[j - 1]] += 1
                max_cnt = max(max_cnt, mp[s[j - 1]])
                if len(mp) * max_cnt == i - j + 1 and dp[j - 1] != inf:
                    dp[i] = min(dp[i], dp[j - 1] + 1)
        return int(dp[n])


if __name__ == '__main__':
    print(Solution().minimumSubstringsInPartition("fabccddg"))
