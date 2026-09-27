/*
    If str length is 0, return empty string
    If str of length is 1, return first string
    Initiatilize output with first index of 'strs'
    Store 'output' length in 'minLen'
    Loop 'strs' as 'str' from 1st index
        Override minLen with str if its length is smaller
        Loop if str of minLen doesn't matches with output of minLen and minLen > 0
            minLen--
    return output of minLen

*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String output = strs[0];
        int minLen = output.length();
        for(String str : strs) {
            if(str.length() < minLen) minLen = str.length();
            while(minLen > 0 && !str.substring(0, minLen).equals(output.substring(0, minLen))) {
                minLen--;
            }
        }
        return output.substring(0, minLen);
    }
}