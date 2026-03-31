class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;    

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        int minVal = !minStack.empty() ? minStack.peek() : val;
        
        minVal = val < minVal ? val : minVal;

        minStack.push(minVal);
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
