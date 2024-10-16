from typing import List


class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        def check(t: int) -> bool:
            cnt = 0
            for i in time:
                cnt += t // i
            return cnt >= totalTrips
        l = 1
        r = min(time) * totalTrips
        while l < r:
            mid = l + (r - l) // 2
            if check(mid):
                r = mid
            else:
                l = mid + 1
        return l