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
        int frozenIdx = -1;
        int i = 0;

        while (i < s.length()) {
            if(seenMap.containsKey(s.charAt(i)) && seenMap.get(s.charAt(i)) > frozenIdx) {
                maxLen = Math.max(maxLen, i - 1 - frozenIdx);
                frozenIdx = seenMap.get(s.charAt(i));
            }
            seenMap.put(s.charAt(i), i);
            i++;
        }
        maxLen = Math.max(maxLen, i - 1 - frozenIdx);

        return maxLen;
    }
}
