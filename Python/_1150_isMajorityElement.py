from collections import Counter
from typing import List


class Solution:
    def isMajorityElement(self, nums: List[int], target: int) -> bool:
        count = 0
        for num in nums:
            if num == target:
                count += 1
                if count > len(nums) // 2:
                    return True
        return False


# 这很python
class Solution2:
    def isMajorityElement(self, nums: List[int], target: int) -> bool:
        return nums.count(target) > len(nums) // 2


if __name__ == '__main__':
    print(Solution().isMajorityElement([438885258], 786460391))