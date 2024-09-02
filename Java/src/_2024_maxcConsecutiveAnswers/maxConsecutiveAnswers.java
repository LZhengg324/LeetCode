package _2024_maxcConsecutiveAnswers;

public class maxConsecutiveAnswers {
    public static void main(String[] args) {
        System.out.println(new Solution().maxConsecutiveAnswers("TFFT", 1));
    }
}

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveChar('T', answerKey, k), maxConsecutiveChar('F', answerKey, k));
    }

    private int maxConsecutiveChar(char target, String answerKey, int k) {
        int sum = 0;
        int max = 0;
        char[] chars = answerKey.toCharArray();
        for (int left = 0, right = 0; right < chars.length; right++) {
            sum += chars[right] == target ? 1 : 0;
            while (sum > k) {
                sum -= chars[left++] == target ? 1 : 0;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
