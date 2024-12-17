package _632_smallestRange;

import java.util.*;

public class _632_smallestRange {
}

// 排序 + 滑动窗口
class Solution1 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            for (Integer num : nums.get(i)) {
                list.add(new int[]{num, i});
            }
        }
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });
        int left = 0, right = 0;
        int[] counter = new int[k];
        int cnt = 0;
        int[] res = new int[]{0, Integer.MAX_VALUE};

        while (right < list.size()) {
            while (right < list.size() && cnt < k) {

                if (counter[list.get(right)[1]] == 0) {
                    cnt++;
                }

                counter[list.get(right)[1]] += 1;
                right += 1;
            }
            while (left < right && cnt == k) {
                counter[list.get(left)[1]] -= 1;
                if (counter[list.get(left)[1]] == 0) {
                    cnt--;
                }
                left += 1;
            }
            int leftbound = list.get(left - 1)[0];
            int rightbound = list.get(right - 1)[0];
            int diff = rightbound - leftbound;
            if (diff < res[1] - res[0]) {
                res[0] = leftbound;
                res[1] = rightbound;
            }
        }
        return res;
    }
}

// 贪心 + 最小堆
class Solution2 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] pointer = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return nums.get(i1).get(pointer[i1]) - nums.get(i2).get(pointer[i2]);
            }
        });
        int leftbound = 0, rightbound = Integer.MAX_VALUE;
        int minRange = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            pq.offer(i);
            max = Math.max(max, nums.get(i).get(pointer[i]));
        }
        while (true) {
            int minIndex = pq.poll();
            int range = max - nums.get(minIndex).get(pointer[minIndex]);
            if (range < minRange) {
                minRange = range;
                leftbound = nums.get(minIndex).get(pointer[minIndex]);
                rightbound = max;
            }
            pointer[minIndex] += 1;
            if (nums.get(minIndex).size() == pointer[minIndex]) {
                break;
            }
            pq.offer(minIndex);
            // 更新当前指针索引中的最大值
            max = Math.max(max, nums.get(minIndex).get(pointer[minIndex]));
        }

        return new int[]{leftbound, rightbound};
    }
}