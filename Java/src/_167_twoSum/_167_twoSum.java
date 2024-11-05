package _167_twoSum;

public class _167_twoSum {

}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] > target) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        return new int[]{i + 1, j + 1};
    }
}