class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        var map = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        for(int i = 0; i < t.length(); i++) {
            if(map.getOrDefault(t.charAt(i), 0) == 0) {
                return false;
            }
            map.merge(t.charAt(i), -1, Integer::sum);
        }

        return true;
    }
}
