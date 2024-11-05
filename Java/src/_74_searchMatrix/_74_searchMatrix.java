package _74_searchMatrix;

public class _74_searchMatrix {
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left, right;
        int m = matrix.length, n = matrix[0].length;
        left = -1;
        right = m;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int row = Math.max(left, 0);
        left = -1;
        right = n;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        int column = Math.max(left, 0);
        return matrix[row][column] == target;
    }
}