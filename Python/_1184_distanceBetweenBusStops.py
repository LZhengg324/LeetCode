from typing import List


class Solution:
    def distanceBetweenBusStops(self, distance: List[int], start: int, destination: int) -> int:
        if start > destination:
            start, destination = destination, start
        return min(sum(distance[start : destination]), sum(distance[:start]) + sum(distance[destination:]))


if __name__ == '__main__':
    print(Solution().distanceBetweenBusStops([1,2,3,4], 0, 1))
