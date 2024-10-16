from typing import List


class Solution:
    def destCity(self, paths: List[List[str]]) -> str:
        a = set()
        b = set()
        for start, to in paths:
            b.discard(start)
            if to not in a:
                b.add(to)
            a.add(start)
        return b.pop()
