package _200_numIslands;

public class _200_numIslands {
    public static void main(String[] args) {

    }
}

class Solution {    //该题还可以用BFS来做
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        dfs(grid, row - 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row + 1, column);
        dfs(grid, row, column + 1);
    }
}

