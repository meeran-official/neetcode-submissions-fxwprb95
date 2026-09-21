/*

isAnagram:
    Store character freq of 's' in 'freqS'
    Store character freq of 't' in 'freqT'
    return true if they match

*/

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freqS = new HashMap<>();
        Map<Character, Integer> freqT = new HashMap<>();
        for(char c : s.toCharArray()) {
            freqS.merge(c, 1, Integer::sum);
        }
        for(char c : t.toCharArray()) {
            freqT.merge(c, 1, Integer::sum);
        }
        return freqS.equals(freqT);
    }
}
