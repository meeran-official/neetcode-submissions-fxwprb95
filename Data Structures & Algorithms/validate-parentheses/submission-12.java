class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        Map<Character, Character> bracketPairs = Map.of(
            '{', '}',
            '[', ']',
            '(', ')'
        );
        for(char b : s.toCharArray()) {
            if(bracketPairs.containsKey(b)) {
                brackets.push(b);
            } else {
                if(brackets.isEmpty()) return false;
                char openBracket = brackets.pop();
                if (bracketPairs.get(openBracket) != b) {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}