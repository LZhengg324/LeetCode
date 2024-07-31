from math import inf
from typing import List


class Solution:
    def findValueOfPartition(self, nums: List[int]) -> int:
        nums.sort()
        minimum = inf
        for i in range(len(nums) - 1):
            if abs(nums[i] - nums[i + 1]) < minimum:
                minimum = abs(nums[i] - nums[i + 1])
        return minimum
