package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum {
    public static void main(String[] args) {
        List<List<Integer>> ans = new Solution().combinationSum(new int[]{4,2,8}, 8);
        System.out.println(ans);
    }
}

class Solution {    //递归
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        sum(list, candidates, 0, target, 0);
        return ans;
    }

    public void sum(List<Integer> list, int[] candidates, int sum, int target, int index) {
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] + sum > target) {
                continue;
            }
            list.add(candidates[i]);
            if (candidates[i] + sum == target) {
                ans.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                continue;
            }
            sum(list, candidates, sum + candidates[i], target, i);
            list.remove(list.size() - 1);
        }
    }
}