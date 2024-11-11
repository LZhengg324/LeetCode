from collections import Counter
from typing import List


class Solution:
    def countPairs(self, coordinates: List[List[int]], k: int) -> int:
        res = 0
        cnt = Counter()
        for x, y in coordinates:
            for i in range(k + 1):
                res += cnt[(x ^ i, y ^ (k - i))]
            cnt[(x, y)] += 1
        return res

