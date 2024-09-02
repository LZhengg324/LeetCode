package _3142_satisfiesConditions;

public class satisfiesConditions {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i < grid.length - 1) {
                    if (grid[i][j] != grid[i + 1][j]) return false;
                }
                if (j < grid[i].length - 1) {
                    if (grid[i][j] == grid[i][j + 1]) return false;
                }
            }
        }
        return true;
    }
}
