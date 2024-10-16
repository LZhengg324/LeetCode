from typing import List


class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        n = len(tickets)
        res = 0
        for i in range(0, k + 1):
            res += min(tickets[k], tickets[i])
        for i in range(k + 1, n):
            res += min(tickets[i], tickets[k] - 1)
        return res