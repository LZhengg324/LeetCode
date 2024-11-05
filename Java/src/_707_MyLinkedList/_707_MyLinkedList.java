package _707_MyLinkedList;

class MyLinkedList {

    ListNode dummy;
    int size;

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public MyLinkedList() {
        this.dummy = new ListNode(-1, null);
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || this.size <= index) {
            return -1;
        }
        int cnt = -1;
        ListNode cur = dummy;
        while (cnt < index) {
            cur = cur.next;
            cnt += 1;
        }
        return cur.val;
    }

    public void addNode(ListNode pre, ListNode newNode) {
        newNode.next = pre.next;
        pre.next = newNode;
        this.size += 1;
    }

    public void addAtHead(int val) {
        addNode(dummy, new ListNode(val, null));
    }

    public void addAtTail(int val) {
        ListNode cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
        }
        addNode(cur, new ListNode(val, null));
    }

    public void addAtIndex(int index, int val) {
        if (index >= this.size) {
            if (index == this.size) {
                addAtTail(val);
            }
            return;
        }
        ListNode cur = dummy;
        int cnt = -1;
        while (cnt < index - 1) {
            cur = cur.next;
            cnt += 1;
        }
        addNode(cur, new ListNode(val, null));
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || this.size <= index) {
            return;
        }
        ListNode cur = dummy;
        int cnt = -1;
        while (cnt < index - 1) {
            cur = cur.next;
            cnt += 1;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        } else {
            cur.next = null;
        }
        this.size -= 1;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3,0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        list.get(4);
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);

    }
}