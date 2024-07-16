package _215_findKthLargest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _215_findKthLargest {
    public static void main(String[] args) {
        System.out.println(new Solution2().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}

class Solution1 {   //优先队列
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (queue.peek() <= nums[i]) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }
}

class Solution2 {   //堆排序

    private int[] heap;
    private int size = 0;

    public int findKthLargest(int[] nums, int k) {
        this.heap = new int[nums.length + 1];
        for (int num : nums) {
            heapInsert(num);
        }
        for (int i = 0; i < k - 1; i++) {
            deleteMax();
        }
        return this.heap[1];
    }

    private void heapInsert(int num) {
        int place = ++this.size;
        while (place > 1 && this.heap[place / 2] < num) {
            this.heap[place] = this.heap[place / 2];
            place /= 2;
        }
        this.heap[place] = num;
    }

    private void deleteMax() {
        int tmp = this.heap[size--];
        int parent = 1;
        while (parent * 2 <= this.size) {
            int child = parent * 2;
            if (this.heap[child] < this.heap[child + 1]) {  //指向较大的子节点
                child++;
            }
            if (this.heap[child] <= tmp) {
                break;
            } else {
                this.heap[parent] = this.heap[child];
            }
            parent = child;
        }
        this.heap[parent] = tmp;
    }
}

class Solution3 {   //桶排序
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int[] buckets = new int[20001];
        for (int i = 0; i < len; i++) {
            buckets[nums[i] + 10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            k = k - buckets[i];
            if (k <= 0) {
                return i - 10000;
            }
        }
        return -1;
    }
}