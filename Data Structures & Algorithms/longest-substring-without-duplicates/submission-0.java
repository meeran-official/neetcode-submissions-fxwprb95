/*
    abcabcd

*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0;
        int maxCount = 0;
        Set<Character> seen = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            if(!seen.contains(s.charAt(i))) {
                seen.add(s.charAt(i));
                maxCount = Math.max(maxCount, ++count);
            } else {
                seen.clear();
                seen.add(s.charAt(i));
                count = 1;
            }
        }
        return maxCount;
    }
}
