import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] pre = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (i > 0) {
                pre[i] = pre[i - 1] + a[i];
            } else {
                pre[i] = a[i];
            }
        }

        long res = Long.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            res = Math.min(res, (long) (pre[n - 1] - pre[i]) * pre[i]);
        }
        System.out.println(res);
    }
}
