package _27_removeElement;

public class _27_removeElement {
    public static void main(String[] args) {
        System.out.println(new Solution().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[cnt++] = nums[i];
        }
        return cnt;
    }
}