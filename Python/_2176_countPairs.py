from typing import List
from collections import defaultdict


class Solution:
    def countPairs(self, nums: List[int], k: int) -> int:
        cnt = defaultdict(list)
        res = 0
        for j in range(len(nums)):
            if len(cnt[nums[j]]) != 0:
                for i in cnt[nums[j]]:
                    if (i * j) % k == 0:
                        res += 1
            cnt[nums[j]].append(j)
        return res