from functools import cache


class Solution:
    def countSpecialNumbers(self, n: int) -> int:
        s = str(n)
        @cache
        def dfs(i : int, mask: int, isLimit: bool, isNum: bool) -> int:
            if i == len(s):
                return int(isNum)
            res = 0
            if not isNum:   # 前一个位选择跳过
                res += dfs(i + 1, mask, False, False)
            upper = int(s[i]) if isLimit else 9
            for d in range(0 if isNum else 1, upper + 1):
                if mask >> d & 1 == 0:  # 前面的数字没有d
                    res += dfs(i + 1, mask | 1 << d, isLimit and d == upper, True)
            return res
        return dfs(0, 0, True, False)