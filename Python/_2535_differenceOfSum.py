from typing import List


class Solution:
    def differenceOfSum(self, nums: List[int]) -> int:
        res = 0
        for num in nums:
            res += num
            while num:
                res -= num % 10
                num //= 10
        return res