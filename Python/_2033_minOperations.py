from typing import List


class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        l = list()
        for row in grid:
            for ele in row:
                if abs(ele - grid[0][0]) % x != 0:
                    return -1
                l.append(ele)
        l.sort()
        n = len(l)
        res = 0
        for ele in l:
            res += abs(ele - l[n // 2]) // x
        return res