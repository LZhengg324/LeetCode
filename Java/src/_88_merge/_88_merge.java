package _88_merge;

public class _88_merge {
    public static void main(String[] args) {

    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, k = m + n - 1;
        while (p1 > -1 && p2 > -1) {
            if (nums1[p1] > nums2[p2]) {
                nums1[k--] = nums1[p1--];
            } else {
                nums1[k--] = nums2[p2--];
            }
        }
        while (p1 > -1) {
            nums1[k--] = nums1[p1--];
        }
        while (p2 > -1) {
            nums1[k--] = nums2[p2--];
        }
    }
}