class Solution:
    def removeStars(self, s: str) -> str:
        res = []
        for chr in s:
            if chr == '*':
                res.pop()
            else:
                res.append(chr)
        return "".join(res)