from collections import defaultdict
from typing import List


class Solution:
    def countCompleteDayPairs(self, hours: List[int]) -> int:
        cnt = 0
        d = defaultdict(int)
        for hour in hours:
            cnt += d[(24 - (hour % 24)) % 24]
            d[hour % 24] += 1
        return cnt
