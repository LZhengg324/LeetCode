from typing import List


class Solution:
    def numberOfSets(self, n: int, maxDistance: int, roads: List[List[int]]) -> int:
        count = 0
        opened = [0] * n # 记录节点的情况，0表示不存在，>0表示存在
        for mask in range(1 << n):  # 穷举所有节点的情况
            for i in range(n):
                opened[i] = mask & (1 << i)     # 记录节点情况至opened
            d = [[1000000] * n for _ in range(n)]   # d二维数组,记录图
            for i, j , r in roads:
                if opened[i] and opened[j]:   # i和j之间存在边
                    d[i][j] = d[j][i] = min(r, d[i][j])
            # Floyd算法松弛每一个节点
            for k in range(n):
                if opened[k]:
                    for i in range(n):
                        if opened[i]:
                            for j in range(i + 1, n):
                                if opened[j]:
                                    d[i][j] = d[j][i] = min(d[i][j], d[i][k] + d[k][j])
            good_op = 1
            for i in range(n):
                if opened[i]:
                    for j in range(i + 1, n):
                        if opened[j]:
                            if d[i][j] > maxDistance:
                                good_op = 0
                                break
                if not good_op:
                    break
            count += good_op
        return count

if __name__ == '__main__':
    print(Solution().numberOfSets(3, 5, [[0,1,20],[0,1,10],[1,2,2],[0,2,2]]))