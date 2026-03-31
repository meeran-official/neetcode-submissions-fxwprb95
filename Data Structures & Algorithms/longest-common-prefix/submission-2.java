class Solution {
    public String longestCommonPrefix(String[] strs) {

        String output = strs[0];
        int minLen = output.length();

        for(int i = 1; i < strs.length; i++) {
            if(strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
            
            while(minLen > 0 && !output.substring(0, minLen).equals(strs[i].substring(0, minLen))) {
                minLen--;
            }
        }   

        return output.substring(0, minLen);
    }
}