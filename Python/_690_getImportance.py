from collections import deque
from typing import List


class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


# dfs
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        mp = {employee.id: employee for employee in employees}

        def dfs(index: int) -> int:
            employee = mp.get(index)
            res = employee.importance
            for sub in employee.subordinates:
                res += dfs(sub)
            return res

        return dfs(id)


# bfs
class Solution2:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        mp = {employee.id: employee for employee in employees}
        res = 0
        queue = deque([id])
        while queue:
            employee = mp.get(queue.popleft())
            res += employee.importance
            if employee.subordinates:
                for sub in employee.subordinates:
                    queue.append(sub)
        return res
