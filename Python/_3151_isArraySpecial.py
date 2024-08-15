from itertools import pairwise
from typing import List

# class Solution:
#     def isArraySpecial(self, nums: List[int]) -> bool:
#         pre = nums[0] % 2
#         for num in nums[1:]:
#             if pre == num % 2:
#                 return False
#             pre = num % 2
#         return True


class Solution:
    def isArraySpecial(self, nums: List[int]) -> bool:
        return all(y % 2 != x % 2 for x, y in pairwise(nums))


if __name__ == '__main__':
    print(Solution().isArraySpecial([1, 3]))
