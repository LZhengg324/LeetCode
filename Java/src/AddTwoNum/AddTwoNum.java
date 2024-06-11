package AddTwoNum;

public class AddTwoNum {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0); //记录头指针
        ListNode cur = pre; //记录当前指针
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(1);
        }
        return pre.next;
    }
}