from collections import defaultdict, deque
from typing import List


class Solution:
    def include(self, bomb1: List[int], bomb2: List[int]) -> bool:
        x1, y1, r1 = bomb1
        x2, y2, r2 = bomb2
        return (x1 - x2) ** 2 + (y1 - y2) ** 2 <= r1 ** 2  # 判断bomb2圆心是否于bomb1内

    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        d = defaultdict(list)  # 创建一个默认值为列表list的字典作为邻接表
        n = len(bombs)
        # 建图
        for i in range(n):
            for j in range(n):
                if i != j and self.include(bombs[i], bombs[j]):
                    d[i].append(j)
        ret = 0
        # 枚举所有点作为起点, 进行广度优先搜索
        for i in range(n):
            ans = 0
            q = deque()
            q.append(i)
            visited = [0] * n
            while q:
                node = q.popleft()
                if not visited[node]:
                    ans += 1
                    visited[node] = 1
                    for j in d[node]:
                        if not visited[j]:
                            q.append(j)
            ret = max(ans, ret)
        return ret


print(Solution().maximumDetonation([[1, 2, 3], [2, 3, 1], [3, 4, 2], [4, 5, 3], [5, 6, 4]]))
