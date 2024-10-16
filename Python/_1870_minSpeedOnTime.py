from typing import List


class Solution:
    def minSpeedOnTime(self, dist: List[int], hour: float) -> int:
        n = len(dist)
        hr = round(hour * 100)

        if hr <= 100 * (n - 1):
            return -1

        def check(speed: int) -> bool:
            t = 0
            for i in range(n - 1):
                t += (dist[i] - 1) // speed + 1
            t *= speed
            t += dist[-1]
            return t * 100 <= hr * speed

        l, r = 1, 10 ** 7
        while l < r:
            mid = l + (r - l) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l