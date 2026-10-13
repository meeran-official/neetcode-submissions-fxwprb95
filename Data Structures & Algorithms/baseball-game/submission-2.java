class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(String op : operations) {
            if(op.equals("+")) {
                int temp = stack.pop();
                int newTop = stack.peek() + temp;
                stack.push(temp);
                stack.push(newTop);
                sum += stack.peek();
            } else if(op.equals("C")) {
                sum -= stack.pop();                
            } else if(op.equals("D")) {
                stack.push(stack.peek() * 2);
                sum += stack.peek();
            } else {
                stack.push(Integer.parseInt(op));
                sum += stack.peek();
            }        
        }
        return sum;
    }
}