/*  0   1   2   3   4   5   6   7   8   9   10  11  12
    y   x   a   b   c   z   a   x   y   x   d   e   f
                                                    i
    
    frozenIdx = 7
    maxLen = 6

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character, Integer> seenMap = new HashMap<>();
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            if(seenMap.containsKey(s.charAt(r))) {
                l = Math.max(l, seenMap.get(s.charAt(r)) + 1);
            }
            seenMap.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
