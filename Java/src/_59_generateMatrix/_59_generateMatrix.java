package _59_generateMatrix;

public class _59_generateMatrix {
}

class Solution {
    public int[][] generateMatrix(int n) {
        int numMax = n * n;
        int cur = 1;
        int row = 0, column = 0;
        int[][] mat = new int[n][n];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        while (cur <= numMax) {
            mat[row][column] = cur++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextColumn < 0 || nextRow >= n || nextColumn >= n || mat[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return mat;

    }
}