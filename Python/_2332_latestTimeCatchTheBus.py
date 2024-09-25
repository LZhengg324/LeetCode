from typing import List


class Solution:
    def latestTimeCatchTheBus(self, buses: List[int], passengers: List[int], capacity: int) -> int:
        buses.sort()
        passengers.sort()
        pos = 0
        space = 0
        for arrive in buses:
            space = capacity
            while space > 0 and pos < len(passengers) and passengers[pos] <= arrive:
                space -= 1
                pos += 1
        pos -= 1
        time = buses[-1] if space > 0 else passengers[pos]
        while pos >= 0 and passengers[pos] == time:
            pos -= 1
            time -= 1
        return time