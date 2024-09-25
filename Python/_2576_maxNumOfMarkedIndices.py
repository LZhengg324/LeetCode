from typing import List


class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        i = 0
        res = 0
        for j in range ((n + 1) // 2, n):
            if 2 * nums[i] <= nums[j]:
                res += 2
                i += 1
        return res