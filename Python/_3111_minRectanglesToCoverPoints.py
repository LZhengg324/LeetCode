from typing import List


class Solution:
    def minRectanglesToCoverPoints(self, points: List[List[int]], w: int) -> int:
        points.sort(key=lambda p: p[0])
        n = len(points)
        cur = points[0][0]
        cnt = 1
        for i in range(1, n):
            if points[i][0] - cur > w:
                cnt += 1
                cur = points[i][0]
        return cnt


if __name__ == '__main__':
    print(Solution().minRectanglesToCoverPoints([[0,0],[1,1],[2,2],[3,3],[4,4],[5,5],[6,6]], 2))
