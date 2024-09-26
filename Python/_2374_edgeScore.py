from collections import defaultdict
from typing import List


class Solution:
    def edgeScore(self, edges: List[int]) -> int:
        score = [0] * len(edges)
        for i, edge in enumerate(edges):
            score[edge] += i
        return score.index(max(score))


if __name__ == '__main__':
    print(Solution().edgeScore([1,0,0,0,0,7,7,5]))