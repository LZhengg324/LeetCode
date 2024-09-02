from functools import cache


class Solution:
    def waysToReachStair(self, k: int) -> int:
        @cache
        def dfs(pos: int, jump: int, can_down: bool) -> int:
            if pos > k + 1:
                return 0
            ways = 1 if pos == k else 0
            if pos > 0 and can_down:
                ways += dfs(pos - 1, jump, False)
            ways += dfs(pos + (1 << jump), jump + 1, True)
            return ways
        return dfs(1, 0, True)


if __name__ == '__main__':
    print(Solution().waysToReachStair(0))
