class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            tArr[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(sArr, tArr);
    }
}
