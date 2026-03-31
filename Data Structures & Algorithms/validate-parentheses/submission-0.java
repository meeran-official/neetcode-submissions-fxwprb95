class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            
            if((p == '(' || p == '{' || p == '[')) {
                stack.add(p);            
                continue;
            }

            if(stack.size() == 0) {
                return false;
            }

            char popped = stack.remove(stack.size()-1);
        
            if (p == ')' && popped != '(') {
                return false;
            } else if (p == '}' && popped != '{') {
                return false;
            } else if (p == ']' && popped != '[') {
                return false;
            }
        }

        return stack.size() == 0;
    }
}
