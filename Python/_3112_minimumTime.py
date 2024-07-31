import heapq
from typing import List


class Solution:
    def minimumTime(self, n: int, edges: List[List[int]], disappear: List[int]) -> List[int]:
        adj = [[] for _ in range(n)]    # 邻接矩阵，不能直接构图，题目说明可能存在重边
        # 建立邻接矩阵
        for u, v, length in edges:
            adj[u].append([v, length])
            adj[v].append([u, length])
        pq = [[0, 0]]  # 优先队列  [权值，到达节点]
        answer = [-1] * n
        answer[0] = 0
        while pq:
            w, u = heapq.heappop(pq)
            if w != answer[u]:  # 可能出现重边，较长的权值先于较短的权值的边推入优先队列，需选择最优边
                continue
            for v, length in adj[u]:
                if w + length < disappear[v] and (w + length < answer[v] or answer[v] == -1):
                    answer[v] = w + length
                    heapq.heappush(pq, [w + length, v])
        return answer


if __name__ == '__main__':
    print(Solution().minimumTime(3, [[2,0,9],[1,0,5],[2,2,4],[0,1,10],[1,1,10],[1,1,10],[2,2,10],[1,1,10]], [4, 13, 19]))