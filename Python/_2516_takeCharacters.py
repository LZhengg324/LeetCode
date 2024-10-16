class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        cnt = [0] * 3
        ans = len(s)

        for c in s:
            cnt[ord(c) - ord('a')] += 1
        if cnt[0] >= k and cnt[1] >= k and cnt[2] >= k:
            ans = min(ans, len(s))
        else:
            return -1

        l = 0
        for r, ch in enumerate(s):
            cnt[ord(ch) - ord('a')] -= 1
            while l < r and (cnt[0] < k or cnt[1] < k or cnt[2] < k):
                cnt[ord(s[l]) - ord('a')] += 1
                l += 1
            if cnt[0] >= k and cnt[1] >= k and cnt[2] >= k:
                ans = min(ans, len(s) - (r - l + 1))

        return ans