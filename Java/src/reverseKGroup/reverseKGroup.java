package reverseKGroup;

public class reverseKGroup {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseKGroup(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        //记录1-k个节点中的第0个节点
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            //记录第k+1个节点
            ListNode next = tail.next;
            ListNode[] afterReverse = reverseList(head, tail);
            head = afterReverse[0];
            tail = afterReverse[1];
            //链表接回原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = pre.next;
        }
        return dummy.next;
    }

    private ListNode[] reverseList(ListNode head, ListNode tail) {  //返回格式[0] = head, [1]=tail
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }
}