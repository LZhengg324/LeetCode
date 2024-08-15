from cmath import inf
from typing import List


class Solution:
    def addedInteger(self, nums1: List[int], nums2: List[int]) -> int:
        min_nums1 = inf
        for num in nums1:
            min_nums1 = min(num, min_nums1)
        min_nums2 = inf
        for num in nums2:
            min_nums2 = min(num, min_nums2)
        return min_nums2 - min_nums1


class Solution2:
    def addedInteger(self, nums1: List[int], nums2: List[int]) -> int:
        return (sum(nums1) - sum(nums2)) // len(nums1)
