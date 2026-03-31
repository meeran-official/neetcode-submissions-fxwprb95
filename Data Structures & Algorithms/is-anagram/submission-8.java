class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            count[sArr[i] - 'a']++;
            count[tArr[i] - 'a']--;
        }

        for(int num : count) {
            if(num != 0) return false;
        }

        return true;
    }
}
