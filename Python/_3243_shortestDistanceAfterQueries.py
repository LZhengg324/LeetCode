from collections import deque
from typing import List


class Solution:
    def shortestDistanceAfterQueries(self, n: int, queries: List[List[int]]) -> List[int]:
        graph = [[i + 1] for i in range(n)]
        answer = []
        for start, to in queries:
            graph[start].append(to)
            answer.append(self.bfs(graph))
        return answer

    def bfs(self, graph: List[List[int]]) -> int:
        dist = [-1] * len(graph)
        dist[0] = 0
        q = deque([0])
        while q:
            x = q.popleft()
            for y in graph[x]:
                if dist[y] < 0:
                    dist[y] = dist[x] + 1
                    q.append(y)
            if dist[len(graph) - 1] >= 0:
                break
        return dist[len(graph) - 1]