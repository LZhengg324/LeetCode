from typing import List


class Solution:
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        roads = list(range(1, n))
        res = []
        cnt = n - 1
        for l, r in queries:
            if 0 < roads[l] < r:
                i = roads[l]
                while i != -1 and i < r:
                    roads[i], i = -1, roads[i]
                    cnt -= 1
                roads[l] = r
            res.append(cnt)
        return res