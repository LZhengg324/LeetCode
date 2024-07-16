package _2813_findMaximumElegance;

import java.util.*;

public class _2813_findMaximumElegance {
    public static void main(String[] args) {

    }
}

class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (item0, item1) -> item1[0] - item0[0]);
        HashSet<Integer> rec = new HashSet<>(); //记录categories的数量
        ArrayDeque<Integer> stack = new ArrayDeque<>(); //栈，作为记录categories中>1个项的较小的profit项
        long max = 0;
        long profit = 0;
        for (int i = 0; i < items.length; i++) {
            //max_elegance = total_profit + distinct_categories^2
            //不考虑类别相同情况，不会增加distinct_categories，反而降低total_profit
            //不考虑换出来的类别只有一个，不会增加distinct_categories，反而降低total_profit;
            if (i < k) {
                if (!rec.add(items[i][1])) {
                    stack.push(items[i][0]);
                }
                profit += items[i][0];
            } else if (!stack.isEmpty()) {
                if (rec.add(items[i][1])) {
                    profit += items[i][0] - stack.pop();
                }
            }
            max = Math.max(max, profit + (long)rec.size() * (long)rec.size());
        }
        return max;
    }
}