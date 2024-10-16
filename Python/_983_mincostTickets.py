from functools import cache
from typing import List


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        durations = [1, 7, 30]
        @cache
        def dp(i: int) -> int:
            if i > 365:
                return 0
            elif i in days:
                return min(dp(i + d) + c for c, d in zip(costs, durations))
            else:
                return dp(i + 1)
        return dp(1)