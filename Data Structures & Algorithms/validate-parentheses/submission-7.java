class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        Map<Character, Character> bracketPairs = Map.of(
            '{', '}',
            '[', ']',
            '(', ')'
        );
        List<Character> openBrackets = List.of('{', '[', '(');
        for(char b : s.toCharArray()) {
            if(openBrackets.contains(b)) {
                brackets.push(b);
            } else {
                if(bracketPairs.isEmpty()) return false;
                if (bracketPairs.get(brackets.pop()) != b) {
                    return false;
                }
            }
        }
        return true;
    }
}