package _40_combinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_combinationSum2 {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{10,1,1,2,7,6,1,5}, 8));
    }
}

class Solution {    //递归
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        sum(list, candidates, 0, 0, target);
        return ans;
    }

    private void sum(List<Integer> list, int[] candidates, int sum, int index, int target) {
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum + candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            if (sum + candidates[i] == target) {
                ans.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                continue;
            }
            sum(list, candidates, sum + candidates[i], i + 1, target);
            list.remove(list.size() - 1);
        }
    }
}