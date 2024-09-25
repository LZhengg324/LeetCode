from typing import List


# 灵茶山艾府（1324模式思路）
class Solution:
    def countQuadruplets(self, nums: List[int]) -> int:
        n = len(nums)
        cnt4 = 0
        cnt3 = [0] * n
        for l in range(2, n):
            cnt2 = 0
            for j in range(l):
                # 找到 3 < 4
                if nums[j] < nums[l]:
                    cnt4 += cnt3[j]
                    # 把 j 视作 i, l 视作 k, 找到12模式
                    cnt2 += 1
                # 把 l 视作 k, 找到nums[j] > nums[k], 维护132模式的个数
                else:
                    cnt3[j] += cnt2
        return cnt4
