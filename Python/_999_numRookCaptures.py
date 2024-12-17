from typing import List, Tuple

class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        rook = ()
        for i in range(8):
            for j in range(8):
                if board[i][j] == 'R':
                    rook = (i, j)
        directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]
        cnt = 0

        def find(direction: Tuple[int, int]):
            i, j = direction
            rx, ry = rook
            while 0 <= rx + i < 8 and 0 <= ry + j < 8:
                if board[rx + i][ry + j] == 'p':
                    return 1
                elif board[rx + i][ry + j] == 'B':
                    return 0
                rx += i
                ry += j
            return 0

        for direction in directions:
            cnt += find(direction)
        return cnt
