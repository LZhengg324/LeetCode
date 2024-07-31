from typing import List


class Solution:
    def minimumLevels(self, possible: List[int]) -> int:
        n = len(possible)
        bob_score = 0
        alice_score = 0
        for i in range(n):
            if not possible[i]:
                bob_score -= 1
            else:
                bob_score += 1
        for i in range(n - 1):
            if possible[i]:
                alice_score += 1
                bob_score -= 1
            else :
                alice_score -= 1
                bob_score += 1
            if alice_score > bob_score:
                return i + 1
        return -1

if __name__ == '__main__':
    print(Solution().minimumLevels([1,1]))