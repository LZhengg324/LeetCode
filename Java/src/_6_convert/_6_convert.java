package _6_convert;

public class _6_convert {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(new Solution2().convert(s, 3));
    }
}

class Solution1 {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int t = numRows + numRows - 2;  //一周期多少个字符
        int c = (int)Math.ceil(((double) s.length() / t)) * (1 + numRows - 2);  //分为多少周期 * 一周期要用的列数
        char[][] mat = new char[numRows][c];
        for (int i = 0, x = 0, y = 0; i < s.length(); i++) {
             mat[x][y] = s.charAt(i);
            if (i % t < numRows - 1) {
                x++;
            } else {
                x--;
                y++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] > 0) {
                    sb.append(mat[i][j]);
                }
            }
        }
        return sb.toString();
    }
}

class Solution2 {   //不记录空字符串
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int t = numRows + numRows - 2;  //一周期多少个字符
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }
        for (int i = 0, x = 0; i < s.length(); i++) {
            builders[x].append(s.charAt(i));
            if (i % t < numRows - 1) {
                x++;
            } else {
                x--;
            }
        }
        for (int i = 1; i < numRows; i++) {
            builders[0].append(builders[i]);
        }
        return builders[0].toString();
    }
}