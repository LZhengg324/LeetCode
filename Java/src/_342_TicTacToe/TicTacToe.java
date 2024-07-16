package _342_TicTacToe;

class TicTacToe {   //暴力解
    private char[][] board;
    public TicTacToe(int n) {
        this.board = new char[n][n];
    }

    public int move(int row, int col, int player) {
        char ch = player == 1 ? 'O' : 'X';
        this.board[row][col] = ch;
        if (checkColumn(col) || checkRow(row) || (row == col && checkDiagonal()) || (row == board.length - col - 1 && checkAntiDiagonal())) {
            return player;
        }
        return 0;
    }

    private boolean checkAntiDiagonal() {
        for (int i = 1; i < board.length; i++) {
            if (board[i][board.length - i - 1] != board[i - 1][board.length - i]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal() {
        for (int i = 1; i < board.length; i++) {
            if (board[i][i] != board[i - 1][i - 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row) {
        for (int i = 1; i < board.length; i++) {
            if (board[row][i] != board[row][i - 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int column) {
        for (int i = 1; i < board.length; i++) {
            if (board[i - 1][column] != board[i][column]) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */


class TicTacToe2 {   //优雅版
    private final int size;
    private int[][] row;
    private int[][] col;
    private int[] diag;
    private int[] antiDiag;


    public TicTacToe2(int n) {
        this.size = n;
        this.row = new int[2][n];
        this.col = new int[2][n];
        this.diag = new int[2];
        this.antiDiag = new int[2];
    }

    public int move(int row, int col, int player) {
        if (++this.row[player - 1][row] == this.size) {
            return player;
        }
        if (++this.col[player - 1][col] == this.size) {
            return player;
        }
        if (row == col && ++diag[player - 1] == this.size) {
            return player;
        }
        if (row == size - col - 1 && ++antiDiag[player - 1] == this.size) {
            return player;
        }
        return 0;
    }
}