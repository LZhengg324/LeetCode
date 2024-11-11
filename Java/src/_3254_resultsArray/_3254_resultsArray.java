package _3254_resultsArray;

public class _3254_resultsArray {
}

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int l = 0, r = k - 1;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int flag = -1;
        int index = 0;
        for (int i = 1; i <= r; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                flag = i;
            }
        }
        while (r < n) {
            res[index] = l >= flag ? nums[r] : -1;
            // if (l >= flag) {
            //     res[index] = nums[r];
            // } else {
            //     res [index] = -1
            // }
            index += 1;
            r++;
            l++;
            if (r < n && nums[r - 1] + 1 != nums[r]) {
                flag = r;
            }
        }
        return res;
    }
}