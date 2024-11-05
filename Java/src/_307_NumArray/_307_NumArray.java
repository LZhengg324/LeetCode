package _307_NumArray;

public class _307_NumArray {
}

class NumArray {

    private int[] segmentTree;
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        segmentTree = new int[n * 4];
        build(0, 0, n - 1, nums);
    }

    public void update(int index, int val) {
        change(index, val, 0, 0, n - 1);
    }

    public int sumRange(int left, int right) {
        return range(left, right, 0, 0, n - 1);
    }

    private void build(int index, int start, int end, int[] nums) {
        if (start == end) {
            segmentTree[index] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(index * 2 + 1, start, mid, nums);
        build (index * 2 + 2, mid + 1, end, nums);
        segmentTree[index] = segmentTree[index * 2 + 1] + segmentTree[index * 2 + 2];
    }

    private int range(int left, int right, int index, int start, int end) {
        if (left == start && right == end) {
            return segmentTree[index];
        }
        int mid = start + (end - start) / 2;
        if (right <= mid) {
            return range(left, right, index * 2 + 1, start, mid);
        } else if (left > mid) {
            return range(left, right, index * 2 + 2, mid + 1, end);
        } else {
            return range(left, mid, index * 2 + 1, start, mid) + range(mid + 1, right, index * 2 + 2, mid + 1, end);
        }
    }

    private void change(int target, int value, int index, int start, int end) {
        if (start == end) {
            segmentTree[index] = value;
            return;
        }
        int mid = start + (end - start) / 2;
        if (target <= mid) {
            change(target, value, index * 2 + 1, start, mid);
        } else {
            change(target, value, index * 2 + 2, mid + 1, end);
        }
        segmentTree[index] = segmentTree[index * 2 + 1] + segmentTree[index * 2 + 2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */