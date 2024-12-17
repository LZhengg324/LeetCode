from sortedcontainers import SortedList
from typing import List
from math import inf

class Solution:
    def closestRoom(self, rooms: List[List[int]], queries: List[List[int]]) -> List[int]:
        # 离线算法
        rooms.sort(key=lambda r: r[1])  # 将房间size小到大排序
        sl = SortedList()
        ans = [-1] * len(queries)
        j = len(rooms) - 1
        for i in sorted(range(len(queries)), key=lambda i : -queries[i][1]):    # 将minSize从大到小排序
            preferred_id, min_size = queries[i]
            while j >= 0 and rooms[j][1] >= min_size:
                sl.add(rooms[j][0])
                j -= 1
            diff = inf
            k = sl.bisect_left(preferred_id)
            if k:   # 左边能差
                diff = preferred_id - sl[k - 1]
                ans[i] = sl[k - 1]
            if k < len(sl) and sl[k] - preferred_id < diff:
                ans[i] = sl[k]
        return ans

