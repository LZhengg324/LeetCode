from itertools import pairwise


class Solution:
    def longestContinuousSubstring(self, s: str) -> int:
        mx = 1
        cur = 1
        for x, y in pairwise(map(ord, s)):
            if x + 1 == y:
                cur += 1
            else:
                cur = 1
            mx = max(mx, cur)
        return mx
