from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        i = s = min_s = 0
        ans = 0
        while i < n:
            s += gas[i] - cost[i]
            if s < min_s:
                min_s = s
                ans = i + 1
            i += 1
        return -1 if s < 0 else ans