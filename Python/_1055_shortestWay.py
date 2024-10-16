class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        srcset = set(source)
        tgtset = set(target)

        if tgtset - srcset:
            return -1

        m, n = len(source), len(target)
        srcidx = 0
        tgtidx = 0

        while tgtidx < n:
            while source[srcidx % m] != target[tgtidx]:
                srcidx += 1
            srcidx += 1
            tgtidx += 1

        return (srcidx - 1) // m + 1