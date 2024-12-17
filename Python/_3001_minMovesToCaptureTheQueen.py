class Solution:
    def minMovesToCaptureTheQueen(self, a: int, b: int, c: int, d: int, e: int, f: int) -> int:
        # 若皇后与牢车在同一行
        if a == e:
            # 牢象不挡道
            if c != a or d < min(b, f) or d > max(b, f):
                return 1
        # 若皇后与牢车在同一列
        if b == f:
            # 牢象不挡道
            if d != b or c < min(a, e) or c > max(a, e):
                return 1
        # 若皇后和牢象在同一对角线（两点共线，这里的斜率m的情况只有1或-1）
        if abs(c - e) == abs(d - f):
            # 若三点不共线
            if (a - c) * (d - f) != (c - e) * (b - d):
                return 1
            # 若三点共线，但牢车不挡道
            if a < min(c, e) or a > max(c, e):
                return 1
        return 2