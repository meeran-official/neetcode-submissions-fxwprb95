class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = 0;
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            min = val;
            stack.push(0);
            return;
        }
        stack.push(val - min);
        min = Math.min(min, val);
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        int popped = stack.pop();
        min = popped < 0 ? min - popped : min;
    }
    
    public int top() {
        int peek = stack.peek();
        return peek > 0 ? peek + min : min;
    }
    
    public int getMin() {
        return min;
    }
}
