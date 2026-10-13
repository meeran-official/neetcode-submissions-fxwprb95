class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String op : operations) {
            if(op.equals("+")) {
                int temp = stack.pop();
                int sum = stack.peek() + temp;
                stack.push(temp);
                stack.push(sum);
            } else if(op.equals("C")) {
                stack.pop();
            } else if(op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else {
                stack.push(Integer.parseInt(op));
            }        
        }
        int sum = 0;
        for(int score : stack) {
            sum += score;
        }
        return sum;
    }
}