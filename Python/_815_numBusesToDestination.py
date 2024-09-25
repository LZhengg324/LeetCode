from collections import defaultdict, deque
from typing import List


class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        mp = defaultdict(list)
        for i, route in enumerate(routes):
            for stop in route:
                mp[stop].append(i)
        if source not in mp or target not in mp:
            return 0 if source == target else -1

        dis = {source: 0}
        q = deque([source])
        while q:
            cur = q.popleft()
            cur_dis = dis[cur]
            for car in mp[cur]:
                # 若还未访问过
                if routes[car]:
                    for stop in routes[car]:
                        if stop not in dis:
                            dis[stop] = cur_dis + 1
                            q.append(stop)
                    routes[car] = None
        return dis.get(target, -1)



def read_input_from_file(filename: str):
    with open(filename, 'r') as file:
        lines = [line.strip() for line in file.readlines()]
        data = []
        i = 0
        while i < len(lines):
            routes = eval(lines[i])
            source = int(lines[i+1])
            target = int(lines[i+2])
            data.append((routes, source, target))
            i += 3
        return data


if __name__ == "__main__":
    # 从 input.txt 文件中读取数据
    data = read_input_from_file('input.txt')

    # 创建 Solution 实例并调用方法
    solution = Solution()
    for routes, source, target in data:
        print(solution.numBusesToDestination(routes, source, target))