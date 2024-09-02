package _1450_busyStudent;

public class busyStudent {
    public static void main(String[] args) {
        System.out.println(new Solution().busyStudent(new int[]{1,2,3}, new int[]{3,2,7}, 4));
    }
}

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int sum = 0;
        for (int i = 0; i < startTime.length; i++) {
            sum += queryTime >= startTime[i] && queryTime <= endTime[i] ? 1 : 0;
        }
        return sum;
    }
}
