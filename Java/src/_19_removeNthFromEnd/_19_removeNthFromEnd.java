package _19_removeNthFromEnd;

public class _19_removeNthFromEnd {
    public static void main(String[] args) {
        ListNode list = new Solution().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        ListNode cur = list;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {    //扫描两遍
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
            k++;
        }
        int cnt = k - n;
        cur = dummy;
        while (cnt-- > 0) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
