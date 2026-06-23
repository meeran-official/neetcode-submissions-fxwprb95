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
        if (s.length() == 1) return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketPairs = Map.of('(', ')', '{', '}', '[', ']');

        for(char c : s.toCharArray()) {
            if(bracketPairs.containsKey(c)) {
                stack.push(c);
            } else {
                if(!bracketPairs.get(stack.pop()).equals(c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
