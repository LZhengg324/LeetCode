from collections import Counter
from typing import List


# 计算入度和出度
class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        inDegree = Counter(y for _, y in trust)
        outDegree = Counter(x for x,_ in trust)
        return next((i for i in range(1, n + 1) if inDegree[i] == n - 1 and outDegree[i] == 0), -1)


if __name__ == '__main__':
    print(Solution().findJudge(3, [[1,3],[2,3],[3,1]]))