class MinStack {
    Stack<Long> stack = new Stack<>();
    long min;
    public MinStack() {
        stack = new Stack<>();
        min = 0;
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            min = val;
            stack.push(0L);
            return;
        }
        stack.push(val - min);
        min = Math.min(min, val);
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        long popped = stack.pop();
        min = popped < 0 ? min - popped : min;
    }
    
    public int top() {
        long peek = stack.peek();
        return peek > 0 ? (int) (peek + min) : (int) min;
    }
    
    public int getMin() {
        return (int) min;
    }
}
