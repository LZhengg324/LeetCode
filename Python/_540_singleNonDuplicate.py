from typing import List


class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        n = len(nums)
        l, r = -1, n // 2
        while l + 1 < r:
            mid = (l + r) // 2
            if nums[mid * 2] == nums[mid * 2 + 1]:
                l = mid
            else:
                r = mid
        return nums[r * 2]

