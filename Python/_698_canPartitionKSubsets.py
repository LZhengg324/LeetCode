from functools import cache
from typing import List


class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        total = sum(nums)
        if total % k:
            return False
        per = total // k
        nums.sort()
        if nums[-1] > per:
            return False
        n = len(nums)

        @cache
        def dfs(s: int, p: int) -> bool:
            """
            记忆化搜索
            :param s: 利用位运算记录nums中每个数字的状态 1为可用，0为不可用
            :param p: 记录当前和
            :return:
            """
            # 已遍历结束
            if not s:
                return True
            for i in range(n):
                if p + nums[i] > per:
                    break
                if s & (1 << i) and dfs(s ^ (1 << i), (p + nums[i]) % per):
                    return True
            return False

        return dfs((1 << n) - 1, 0)


# 不能用记忆化搜索，要回溯
class Solution2:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        total = sum(nums)
        if total % k:
            return False
        per = total // k
        nums.sort(reverse=True)
        if nums[0] > per:
            return False
        n = len(nums)
        bucket = [0] * k

        def dfs(index: int) -> bool:
            if index == n:
                return True
            for i in range(k):
                if i > 0 and bucket[i] == bucket[i - 1]:    # 类似记忆化,剪枝
                    continue
                if bucket[i] + nums[index] > per:
                    continue
                bucket[i] += nums[index]
                if dfs(index + 1):
                    return True
                bucket[i] -= nums[index]
            return False
        return dfs(0)


if __name__ == '__main__':
    print(Solution2().canPartitionKSubsets([3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269], 5))
