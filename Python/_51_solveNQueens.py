from typing import List


# 八皇后问题
# 解法一（枚举是否合法）
class Solution1:
    def solveNQueens(self, n: int) -> List[List[str]]:
        attack = [[0] * n for _ in range(n)]
        board = [["."] * n for _ in range(n)]
        res = []

        def isValid(row: int, col: int) -> bool:
            # 该位置会被攻击
            if attack[row][col]:
                return False
            # 检查直线
            for i in range(row, -1, -1):
                if board[i][col] == "Q":
                    return False

            # 检查对角线
            for i in range(row, -1, -1):
                if (col - i >= 0 and board[row - i][col - i] == "Q") or (col + i < n and board[row - i][col + i] == "Q"):
                    return False
            return True

        def backtrack(i: int, n: int):
            # 找到一个方案
            if i == n:
                tmp = []
                for row in board:
                    s = ""
                    for j in row:
                        s += j
                    tmp.append(s)
                res.append(tmp)
                return

            # 找该行应放皇后在哪里
            for j in range(n):
                if isValid(i, j):
                    board[i][j] = "Q"
                    backtrack(i + 1, n)
                    board[i][j] = "."

        backtrack(0, n)
        return res

# 解法二（基于集合的回溯）
class Solution2:
    def solveNQueens(self, n: int) -> List[List[str]]:
        diagonal_left = set()
        diagonal_right = set()
        column = set()
        row = ["."] * n
        queen = [-1] * n    # 记录皇后的摆放位置
        res = []

        def generateBoard():
            board = list()
            for i in range(n):
                row[queen[i]] = 'Q'
                board.append("".join(row))
                row[queen[i]] = "."
            res.append(board)

        def backtrack(row: int):
            if row == n:
                generateBoard()
                return
            for i in range(n):
                if (row + i) in diagonal_left or (row - i) in diagonal_right or i in column:
                    continue
                queen[row] = i
                diagonal_left.add(row + i)
                diagonal_right.add(row - i)
                column.add(i)
                backtrack(row + 1)
                queen[row] = -1
                column.remove(i)
                diagonal_left.remove(row + i)
                diagonal_right.remove(row - i)
        backtrack(0)
        return res

# 解法三（解法二优雅版）
class Solution3:
    def solveNQueens(self, n: int) -> List[List[str]]:
        diagonal_left = [False] * (n * 2 + 1)
        diagonal_right = [False] * (n * 2 + 1)
        column = [False] * n
        queen = [-1] * n    # 记录皇后的摆放位置
        res = []

        def dfs(i: int):
            if i == n:
                res.append(['.' * c + 'Q' + '.' * (n - c - 1) for c in queen])
                return
            for j in range(n):
                if not column[j] and not diagonal_left[i + j] and not diagonal_right[i - j]:
                    queen[i] = j
                    diagonal_left[i + j] = diagonal_right[i - j] = column[j] = True
                    dfs(i + 1)
                    diagonal_left[i + j] = diagonal_right[i - j] = column[j] = False

        dfs(0)
        return res

if __name__ == '__main__':
    d = [0,1,0,0,0,0,0,0]
    print(d[0 - 7], d[1 - 0])