from typing import List


class Solution:
    def semiOrderedPermutation(self, nums: List[int]) -> int:
        n = len(nums)
        first = nums.index(1)
        last = nums.index(n)
        return n - last - 1 + first - (last < first)
