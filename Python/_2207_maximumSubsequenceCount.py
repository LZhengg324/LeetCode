class Solution:
    def maximumSubsequenceCount(self, text: str, pattern: str) -> int:
        res = cnt0 = cnt1 = 0
        for chr in text:
            if chr == pattern[1]:
                res += cnt0
                cnt1 += 1
            if chr == pattern[0]:
                cnt0 += 1
        return res + max(cnt0, cnt1)