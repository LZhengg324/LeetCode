from functools import cache
from math import inf
from typing import List


class Solution:
    def sumOfPowers(self, nums: List[int], k: int) -> int:
        nums.sort()
        n = len(nums)
        mod = 10 ** 9 + 7

        @cache
        def dfs(i: int, rest: int, now_min: int, last: int) -> int:
            """
            深度优先搜索寻找所有长度为 k 的子数组中任意两个元素相减的绝对值最小值之和
            :param i: 当前遍历至 nums 的第 i 位
            :param rest: 还剩余多少 rest 个数字未加入子数组
            :param now_min: 长度为 k 的子数组中当前的最小值
            :param last: 上一个数字
            :return: 所有长度为 k 的子数组中任意两个元素相减的绝对值最小值之和
            """
            if rest == 0:
                return now_min
            if rest > n - i:
                return 0

            # 要第i位元素
            t1 = dfs(i + 1, rest - 1, min(now_min, nums[i] - last), nums[i])
            # 不要第i位元素
            t2 = dfs(i + 1, rest, now_min, last)

            return (t1 + t2) % mod

        return dfs(0, k, inf, -inf)


if __name__ == '__main__':
    print(Solution().sumOfPowers([1,2,3,4], 3))
