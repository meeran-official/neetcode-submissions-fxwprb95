class Node {
    String val;
    Node next;
    Node prev;
    Node(String val) {
        this.val = val;
    }
    Node(String val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
class BrowserHistory {
    Node head;
    Node cur;
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        cur = head;
    }
    
    public void visit(String url) {
        cur.next = new Node(url, null, cur);
        cur = cur.next;
    }
    
    public String back(int steps) {
        while(steps-- > 0 && cur != head) {
            cur = cur.prev;
        }
        return cur.val;
    }
    
    public String forward(int steps) {
        int i = 0;
        while(i++ < steps && cur.next != null) {
            cur = cur.next;
        }
        return cur.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */