from itertools import accumulate
from typing import List
from collections import Counter

class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        cnt = sorted(Counter(arr).values(), reverse=True)
        m = len(arr) // 2
        for i, s in enumerate(accumulate(cnt)):
            if s >= m:
                return i + 1