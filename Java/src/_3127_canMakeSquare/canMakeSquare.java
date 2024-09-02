package _3127_canMakeSquare;

public class canMakeSquare {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (check(grid, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] grid, int i, int j) {
        int count = 0;
        for (int k = 0; k < 2; k++) {
            for (int l = 0; l < 2; l++) {
                if (grid[i + k][j + l] == 'B') count++;
            }
        }
        return count != 2;
    }
}
