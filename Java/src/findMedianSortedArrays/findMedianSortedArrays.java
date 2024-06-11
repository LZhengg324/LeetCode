package findMedianSortedArrays;

public class findMedianSortedArrays {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,3};
        int[] num2 = new int[]{2,4};
        System.out.println(new niubiSolution().findMedianSortedArrays(num1, num2));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int[] num = new int[total];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                num[k++] = nums1[i++];
            } else {
                num[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            num[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            num[k++] = nums2[j++];
        }
        int half = (total) / 2;
        if (total % 2 == 1) {
            return num[half];
        } else {
            return (double) (num[half - 1] + num[half]) / 2;
        }
    }
}

class niubiSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 1) {
            int med = (nums1.length + nums2.length) / 2;
            return getKthNum(nums1, nums2, med + 1);
        } else {
            int mid1 = (nums1.length + nums2.length) / 2 - 1;
            int mid2 = (nums1.length + nums2.length) / 2;
            return (getKthNum(nums1, nums2, mid1 + 1) + getKthNum(nums1, nums2, mid2 + 1)) / 2;
        }
    }

    public double getKthNum(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0; //下标
        while(true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            } else if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;   //nums1新下标
            int newIndex2 = Math.min(index2 + half, length2) - 1;   //nums2新下标
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            if (pivot1 <= pivot2) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
