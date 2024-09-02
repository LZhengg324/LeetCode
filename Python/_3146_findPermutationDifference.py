class Solution:
    def findPermutationDifference(self, s: str, t: str) -> int:
        n = len(s)
        d = {}
        for i in range(n):
            d.setdefault(s[i], i)
        res = 0
        for i in range(n):
            res += abs(d[t[i]] - i)
        return res


# 这很python
class Solution2:
    def findPermutationDifference(self, s: str, t: str) -> int:
        d = {c: i for i, c in enumerate(s)}
        return sum(abs(i - d[c]) for i, c in enumerate(t))


if __name__ == '__main__':
    print(Solution2().findPermutationDifference('abc', 'cba'))
