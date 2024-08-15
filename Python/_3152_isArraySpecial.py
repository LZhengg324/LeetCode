from typing import List


# class Solution:
#     def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
#         n = len(nums)
#         dp = [[True for _ in range(n)] for _ in range(n)]
#         for i in range(n):
#             for j in range(i + 1, n):
#                 if not dp[i][j - 1]:
#                     dp[i][j] = False
#                 else:
#                     dp[i][j] = nums[j - 1] % 2 != nums[j] % 2
#         # for i in range(n):
#         #     for j in range(n):
#         #         print(dp[i][j], end=" ")
#         #     print()
#         ans = []
#         for query in queries:
#             ans.append(dp[query[0]][query[1]])
#         return ans


class Solution:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        n = len(nums)
        dp = [1] * n
        for i in range(1, n):
            if (nums[i] ^ nums[i - 1]) & 1 == 1:
                dp[i] = dp[i - 1] + 1
        return [y - x + 1 <= dp[y] for x, y in queries]



if __name__ == '__main__':
    print(Solution().isArraySpecial([4,3,1,6], [[0,2],[2,3]]))
