from typing import List


class Solution:
    def findWinningPlayer(self, skills: List[int], k: int) -> int:
        max_i = win = 0
        for i in range(1, len(skills)):
            if skills[max_i] < skills[i]:
                max_i = i
                win = 0
            win += 1
            if win == k:
                break
        return max_i
