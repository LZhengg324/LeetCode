package _881_numRescueBoats;

import java.util.Arrays;

public class _881_numRescueBoats {
    public static void main(String[] args) {
        System.out.println(new Solution().numRescueBoats(new int[]{1,2,4,5}, 6));
    }
}

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int cnt = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            cnt++;
        }
        return cnt;
    }
}