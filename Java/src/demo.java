import java.util.Scanner;


public class demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] square = new int[n][m];
        int[] leftView = new int[n];    //记录每行最大值
        int[] frontView = new int[m];   //记录每列最大值
        int zerocount = 0;

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                square[i][j] = in.nextInt();
                frontView[j] = Math.max(frontView[j], square[i][j]);
                max = Math.max(max, square[i][j]);
                if (square[i][j] == 0) {
                    zerocount += 1;
                }
            }
            leftView[i] = max;
        }

        int front = 0;
        int h = frontView[0];
        int count = 1;

        for (int j = 1; j < m; j++) {
            if (frontView[j] != h) {
                front += h * count;
                count = 1;
                h = frontView[j];
            } else {
                count += 1;
            }
        }
        front += h * count;

        int left = 0;
        h = leftView[0];
        count = 1;

        for (int i = 1; i < n; i++) {
            if (leftView[i] != h) {
                left += h  * count;
                count = 1;
                h = leftView[i];
            } else {
                count += 1;
            }
        }
        left += h * count;

        System.out.println(front + " " + left + " " + (n * m - zerocount));
    }
}
