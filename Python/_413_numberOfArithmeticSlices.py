from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return 0
        add = 0
        res = 0
        for i in range(2, len(nums)):
            if nums[i - 1] - nums[i] == nums[i - 2] - nums[i - 1]:
                add += 1
                res += add
            else:
                add = 0
        return res