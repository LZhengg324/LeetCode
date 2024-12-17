import heapq
from typing import List

class Solution:
    def maxSpending(self, values: List[List[int]]) -> int:
        m, n = len(values), len(values[0])
        q = [(values[i][-1], i, n - 1) for i in range(m)]
        heapq.heapify(q)
        res = 0
        for d in range(1, m * n + 1):
            val, i, j = heapq.heappop(q)
            res += val * d
            if j > 0:
                heapq.heappush(q, (values[i][j - 1], i, j - 1))
        return res
