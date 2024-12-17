from typing import List


class Solution:
    def countKConstraintSubstrings(self, s: str, k: int, queries: List[List[int]]) -> List[int]:
        n = len(s)
        cnt = [0, 0]
        prefix = [0] * (n + 1)
        right = [n] * n
        i = 0
        for j in range(len(s)):
            cnt[ord(s[j]) & 1] += 1
            while cnt[0] > k and cnt[1] > k:
                cnt[ord(s[i]) & 1] -= 1
                right[i] = j
                i += 1
            prefix[j + 1] = prefix[j] + j - i + 1
        res = []
        for l, r in queries:
            i = min(right[l], r + 1)
            a = (i - l) * (i - l + 1) // 2
            b = prefix[r + 1] - prefix[i]
            res.append(a + b)
        return res