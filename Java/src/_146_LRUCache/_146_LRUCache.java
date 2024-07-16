package _146_LRUCache;

import java.util.HashMap;

class LRUCache {

    class Node {
        private int key;
        private int value;
        Node prev;
        Node next;

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public int getKey() {
            return this.key;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> rec;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node();
        this.tail = new Node();
        this.rec = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!rec.containsKey(key)) {
            return -1;
        }
        Node node = rec.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = this.head;
        node.next = this.head.next;
        this.head.next = node;
        node.next.prev = node;
        return node.getValue();
    }

    public void put(int key, int value) {
        Node newNode;
        if (!rec.containsKey(key)) {
            newNode = new Node(key, value);
            rec.put(key, newNode);
        } else {
            newNode = rec.get(key);
            newNode.setValue(value);
            newNode.prev.next = newNode.next;
            newNode.next.prev = newNode.prev;
        }
        newNode.prev = head;
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        if (rec.size() > capacity) {
            rec.remove(tail.prev.getKey());
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
        }
        // Node node = head.next;
        // while (node.next != null) {
        //     System.out.println(node.getValue());
        //     node = node.next;
        // }
        // System.out.println("------");
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */