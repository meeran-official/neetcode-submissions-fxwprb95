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
    Node cur;
    public BrowserHistory(String homepage) {
        cur = new Node(homepage);
    }
    
    public void visit(String url) {
        cur.next = new Node(url, null, cur);
        cur = cur.next;
    }
    
    public String back(int steps) {
        while(steps-- > 0 && cur.prev != null) {
            cur = cur.prev;
        }
        return cur.val;
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && cur.next != null) {
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