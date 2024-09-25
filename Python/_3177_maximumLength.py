from collections import defaultdict
from typing import List


class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        dp = defaultdict(lambda: [0] * (k + 1))
        zd = [0] * (k + 1)
        for num in nums:
            tmp = dp[num]
            for j in range(k + 1):
                tmp[j] += 1
                if j > 0:
                    tmp[j] = max(tmp[j], zd[j - 1] + 1)
            for j in range(k + 1):
                zd[j] = max(zd[j], tmp[j])
        return zd[k]
