from collections import defaultdict
from typing import List


class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        names = defaultdict(set)
        for idea in ideas:
            names[idea[0]].add(idea[1:])
        ans = 0
        for pre_a, set_a in names.items():
            for pre_b, set_b in names.items():
                if pre_a == pre_b:
                    continue
                intersect = len(set_a & set_b)
                ans += (len(set_a) - intersect) * (len(set_b) - intersect)
        return ans
