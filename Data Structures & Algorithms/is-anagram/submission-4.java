class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        var freqS = new HashMap<Character, Integer>();
        var freqT = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            freqS.merge(s.charAt(i), 1, Integer::sum);
            freqT.merge(t.charAt(i), 1, Integer::sum);
        }

        return freqS.equals(freqT);
    }
}
