from math import inf
from typing import List


class Solution:
    def maxPointsInsideSquare(self, points: List[List[int]], s: str) -> int:
        min1 = [inf] * 26
        min2 = inf
        for i in range(len(points)):
            t = ord(s[i]) - ord('a')
            d = max(abs(points[i][0]), abs(points[i][1]))
            if d < min1[t]:
                min2 = min(min2, min1[t])
                min1[t] = d
            elif d < min2:
                min2 = d
        return sum(d < min2 for d in min1)


if __name__ == '__main__':
    print(Solution().maxPointsInsideSquare([[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]], "abcda"))