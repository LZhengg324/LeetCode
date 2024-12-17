from typing import List


class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        m, n = len(img), len(img[0])
        res = [[0] * n for _ in range(m)]
        directions = [(0, 0), (0, 1), (1, 0), (-1, 0), (0, -1), (1, 1), (-1, -1), (1, -1), (-1, 1)]
        for i in range(m):
            for j in range(n):
                cnt = 0
                add = 0
                for x, y in directions:
                    x1 = x + i
                    y1 = y + j
                    if not 0 <= x1 < m or not 0 <= y1 < n:
                        continue
                    cnt += 1
                    add += img[x1][y1]
                res[i][j] = add // cnt
        return res


