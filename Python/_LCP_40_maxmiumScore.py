from math import inf
from typing import List


class Solution:
    def maxmiumScore(self, cards: List[int], cnt: int) -> int:
        ans = -inf
        cards.sort(reverse=True)
        tmp = 0
        odd = even = -1
        for i in range(cnt):
            tmp += cards[i]
            if cards[i] % 2 == 1:
                odd = cards[i]
            else:
                even = cards[i]
        if tmp % 2 == 0:
            return tmp
        for i in range(cnt, len(cards)):
            if cards[i] % 2 == 1:
                if even != -1:
                    ans = max(ans, tmp - even + cards[i])
            else:
                if odd != -1:
                    ans = max(ans, tmp - odd + cards[i])
        return ans if ans != -inf else 0


if __name__ == '__main__':
    print(Solution().maxmiumScore([3,3,1], 1))
