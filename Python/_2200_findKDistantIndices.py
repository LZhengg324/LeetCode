from typing import List


class Solution:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        n = len(nums)
        idx = [x for x in range(n) if nums[x] == key]
        ans = []
        for i in range(n):
            for idx_i in idx:
                if abs(i - idx_i) <= k:
                    ans.append(i)
                    break
        return ans


class Solution2:
    def findKDistantIndices(self, nums: List[int], key: int, k: int) -> List[int]:
        n = len(nums)
        right = 0
        ans = []
        for num, index in enumerate(nums):
            if num == key:
                left = max(right, index - k)
                right = min(n - 1, index + k) + 1
                for i in range(left, right):
                    ans.append(i)
        return ans


if __name__ == '__main__':
    print(Solution2().findKDistantIndices([3,4,9,1,3,9,5], 9, 1))