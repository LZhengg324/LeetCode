from typing import List


class NeighborSum:
    directions = [[[0, 1], [1, 0], [-1, 0], [0, -1]], [[1, 1], [-1, 1], [1, -1], [-1, -1]]]
    pos = dict()

    def __init__(self, grid: List[List[int]]):
        self.grid = grid
        self.m = len(grid)
        self.n = len(grid[0])
        for row in range(len(self.grid)):
            for col in range(len(self.grid[row])):
                self.pos[grid[row][col]] = (row, col)

    def adjacentSum(self, value: int) -> int:
        return self.getSum(value, 0)

    def diagonalSum(self, value: int) -> int:
        return self.getSum(value, 1)

    def getSum(self, value: int, index: int) -> int:
        row, col = self.pos[value]
        sum = 0
        for row_offset, col_offset in self.directions[index]:
            new_row, new_col = row + row_offset, col + col_offset
            if (0 <= new_row < self.m) and (0 <= new_col < self.n):
                sum += self.grid[new_row][new_col]
        return sum


# Your NeighborSum object will be instantiated and called as such:
# obj = NeighborSum(grid)
# param_1 = obj.adjacentSum(value)
# param_2 = obj.diagonalSum(value)