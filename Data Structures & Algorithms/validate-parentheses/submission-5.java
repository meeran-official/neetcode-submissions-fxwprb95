/*
    If open bracket, push in stack
    If close bracket, verify if popped open bracket matches

    bracketPairs = ['(', ')', '{', '}', '[', ']']
    stack

    if string input size is 1, return false

    LOOP I in S, while in bound:
        if I in bracketPairs.keys():
            stack.push(I)
        else:
            if (bracketPairs(stack.pop()) != I)
                return false
    
    return true
*/

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else if(c == '(') stack.push(')');
            else {
                if(stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
