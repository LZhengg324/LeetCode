package _148_sortList;

public class _148_sortList {
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
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode mid = head, end = head;
        while (end != tail) {
            mid = mid.next;
            end = end.next;
            if (end != tail) {
                end = end.next;
            }
        }
        ListNode left = sort(head, mid);
        ListNode right = sort(mid, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode dummy = head;

        while (list1 != null && list2 != null) {
            ListNode temp;
            if (list1.val < list2.val) {
                temp = list1;
                list1 = list1.next;
            } else {
                temp = list2;
                list2 = list2.next;
            }
            dummy.next = temp;
            dummy = dummy.next;
        }
        while (list1 != null) {
            dummy.next = list1;
            dummy = dummy.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            dummy.next = list2;
            dummy = dummy.next;
            list2 = list2.next;
        }
        return head.next;
    }
}