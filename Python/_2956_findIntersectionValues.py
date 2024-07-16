from typing import List


class Solution:
    def findIntersectionValues(self, nums1: List[int], nums2: List[int]) -> List[int]:
        s = set(nums2)
        ans1 = 0
        ans2 = 0
        for item in nums1:
            if item in s:
                ans1 += 1
        s.clear()
        s = set(nums1)
        for item in nums2:
            if item in s:
                ans2 += 1
        return [ans1, ans2]

nums1 = [4,3,2,3,1]
nums2 = [2,2,5,2,3,6]
print(Solution().findIntersectionValues(nums1, nums2))