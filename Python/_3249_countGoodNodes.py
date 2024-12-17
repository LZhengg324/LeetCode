from typing import List


class Solution:
    def countGoodNodes(self, edges: List[List[int]]) -> int:
        n = len(edges) + 1
        graph = [[] for _ in range(n)]
        for x, y in edges:
            graph[x].append(y)
            graph[y].append(x)
        res = 0
        def dfs(node: int, parent: int) -> int:
            size = 1
            subTreeSize = 0
            good = True
            for child in graph[node]:
                if child == parent:
                    continue
                size0 = dfs(child, node)
                if subTreeSize == 0:
                    subTreeSize = size0
                elif subTreeSize != size0:
                    good = False
                size += size0
            if good:
                nonlocal res
                res += 1
            return size
        dfs(0, -1)
        return res
