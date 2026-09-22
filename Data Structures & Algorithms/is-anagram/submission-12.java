class Solution {
    /*
        If length don't matches, return false
        Init an array of int size 26
        Loop 's' as a character array
        Increment int array index against 's' char
        Decrement int array index against 't' char
        Loop 26 int array
        If any of the index is not equal to 0, then return false
        return true

    */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int val : arr) {
            if(val != 0) return false;
        }
        return true;
    }
}
