from heapq import heappop, heappush
from typing import List


class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        ans = 0
        fuel_heap = []
        cur = startFuel
        pre_pos = 0
        for pos, fuel in stations:
            cur -= pos - pre_pos
            while fuel_heap and cur < 0:
                cur -= heappop(fuel_heap)
                ans += 1
            if cur < 0:
                return -1
            heappush(fuel_heap, -fuel)
            pre_pos = pos
        return ans
