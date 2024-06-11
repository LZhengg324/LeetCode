package searchRange;

public class searchRange {
    public static void main(String[] args) {
        int[] ans = new Solution().searchRange(new int[]{5,7,7,8,8,10}, 4);
        System.out.println(ans[0] + " " + ans[1]);
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {  //二分查找
        int[] ans = new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] < nums[mid])) {
                ans[0] = mid;
                break;
            } else if ((nums[mid] == target && nums[mid - 1] == nums[mid] ) || nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > nums[mid])) {
                ans[1] = mid;
                break;
            } else if ((nums[mid] == target && nums[mid + 1] == nums[mid] ) || nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
