from typing import List


class Solution:
    def numFriendRequests(self, ages: List[int]) -> int:
        cnt = [0] * 121
        res = 0
        for age in ages:
            cnt[age] += 1
        for age in range(15, 121):  # 小于15无法发送好友请求
            if cnt[age] == 0:
                continue
            lower_bound = age // 2 + 7
            for i in range(lower_bound + 1, age + 1):
                if cnt[i] > 0:
                    res += cnt[age] * cnt[i]
            res -= cnt[age]
        return res



