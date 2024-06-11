package mergeKLists;

import java.util.*;

public class mergeKLists {
    public static void main(String[] args) {
        ListNode a = new ListNode();
        ListNode b = new ListNode();
        ListNode ans = new Solution().mergeKLists(new ListNode[]{null});
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode (int val) {
        this.val = val;
    }

    ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {    //优先队列
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt((ListNode o) -> o.val));
        ListNode head = new ListNode();
        ListNode cur = head;
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            cur = cur.next;
        }
        return head.next;
    }
}
