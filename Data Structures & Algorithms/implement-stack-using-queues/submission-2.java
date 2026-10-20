class MyStack {
    Queue<Integer> queue;
    int top;

    public MyStack() {
        queue = new LinkedList<>();    
    }
    
    public void push(int x) {
        top = x;
        queue.offer(top);
    }

    public int pop() {
        Queue temp = new LinkedList<>();
        for(int i = queue.size(); i > 1; i--) {
            top = queue.poll();
            temp.offer(top); 
        }
        int res = queue.poll();
        queue = temp;
        return res;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */