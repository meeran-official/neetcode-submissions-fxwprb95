class LinkedList {

    private Node head;
    private Node tail;

    public LinkedList() {
        head = new Node(-1);
        tail = head;
    }

    public int get(int index) {
        int i = 0;

        Node cur = head.next;

        while(cur != null) {
            if(i == index) {
                return cur.val;
            }
            i++;
            cur = cur.next;
        }

        return -1;        
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);

        newNode.next = head.next;
        head.next = newNode;

        if(tail == head) {
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);

        tail.next = newNode;
        tail = tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        Node cur = head;

        while(i < index && cur != null) {
            i++;
            cur = cur.next;
        }

        if(cur != null && cur.next != null) {
            if(cur.next == tail) {
                tail = cur;
            }
            Node aux = cur.next;
            cur.next = cur.next.next;
            aux = null;
            cur = null;

            return true;
        }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();

        Node cur = head.next;

        while(cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        return list;
    }
}

class Node {
    private int val;
    private Node next;

    public Node(int val) {
        this(val, null);
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
