class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
    ListNode(int key, int val, ListNode prev, ListNode next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
class LRUCache {
    ListNode head;
    ListNode tail;
    int cap;
    Map<Integer, ListNode> map;
    public LRUCache(int capacity) {
        initListNode();
        cap = capacity;
        map = new HashMap<>();
    }
    public int get(int key) {
        ListNode node = map.get(key);
        if(node == null) return -1;
        detach(node);
        append(node);
        return node.val;
    }
    public void put(int key, int value) {
        ListNode node = map.get(key);
        if(node != null) {
            node.val = value;
            detach(node);
        } else {
            node = new ListNode(key, value);
            map.put(key, node);
        }
        append(node);          
        if(map.size() > cap) evict();
    }
    private void evict() {
        ListNode node = head.next;
        detach(node);
        map.remove(node.key);
    }
    private void detach(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // ListNode prevNode = node.prev;
        // ListNode nextNode = node.next;
        // prevNode.next = node.next;
        // nextNode.prev = node.prev;
    }
    private void append(ListNode node) {
        ListNode prevNode = tail.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = tail;
        tail.prev = node;            
    }
    private void initListNode() {
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1, head, null);
        head.next = tail;
    }
}
