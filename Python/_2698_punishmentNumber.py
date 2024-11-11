class Solution:
    def punishmentNumber(self, n: int) -> int:
        res = 0

        def dfs(s: str, pos: int, target: int, cur: int) -> bool:
            if pos == len(s):
                return cur == target
            curSum = 0
            for i in range(pos, len(s)):
                curSum = curSum * 10 + int(s[i])
                if curSum + cur > target:
                    break
                if dfs(s, i + 1, target, curSum + cur):
                    return True
            return False

        for i in range(1, n + 1):
            if dfs(str(i * i), 0, i, 0):
                res += i * i
        return res
