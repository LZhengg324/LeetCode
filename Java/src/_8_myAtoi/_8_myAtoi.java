package _8_myAtoi;

public class _8_myAtoi {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution().myAtoi("-21474836482"));
    }
}

class Solution {
    public int myAtoi(String s) {
        int ret = 0;
        boolean neg = false;
        int k = 0;
        if (s.isEmpty()) {
            return 0;
        }

        while (k < s.length() && s.charAt(k) == ' ') {
            k++;
        }

        if (k < s.length() && s.charAt(k) == '-') {
            neg = true;
            k++;
        } else if (k < s.length() && s.charAt(k) == '+') {
            k++;
        }

        while (k < s.length() && s.charAt(k) <= '9' && s.charAt(k) >= '0') {
            int tmp = s.charAt(k) - '0';
            if (ret >= 214748364) {
                if (ret > 214748364) {
                    if (neg) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
                if (!neg && tmp >= 7) {
                    return Integer.MAX_VALUE;
                } else if (neg && tmp >= 8) {
                    return Integer.MIN_VALUE;
                }
            }
            ret = ret * 10 + tmp;
            k++;
        }
        if (neg) {
            ret = ret * -1;
        }
        return ret;
    }
}