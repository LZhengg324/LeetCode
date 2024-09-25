from typing import List


# 模拟
class Solution:
    def numberOfPoints(self, nums: List[List[int]]) -> int:
        c = max(num for _, num in nums)
        rec = [0] * (c + 1)
        for x, y in nums:
            for i in range(x, y + 1):
                rec[i] += 1
        return sum(1 for i in rec if not i)


# 差分数组
class Solution2:
    def numberOfPoints(self, nums: List[List[int]]) -> int:
        c = max(num for _, num in nums)
        diff = [0] * (c + 2)
        for x, y in nums:
            diff[x] += 1
            diff[y + 1] -= 1
        ans = count = 0
        for i in range(1, c + 1):
            count += diff[i]
            if count > 0:
                ans += 1
        return ans


if __name__ == '__main__':
    print(Solution().numberOfPoints([[1, 2], [5, 6], [3, 4]]))