/*
0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16
A   A   B   B   B   A   A   B   B   B   A   A   A   B   A   B
        l   r                                        

# k = 3 
# max = 10   

- Place left pointer on the next unique character. Right pointer on left + 1. Reset K length. right is in bound?
    - If right pointer is equal to left pointer, move the right pointer.
    - Else if remaining K count, move forward with right pointer. decrement K count. (out of bound warning)
    - Else take the max length by subtracting left pointer index from right. 



*/

class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int l = 0;
        int r = l + 1;
        int maxLen = 0;
        int x = k;

        while(r < N) {
            if(s.charAt(r) == s.charAt(l) || x-- > 0) {
                r++;
            } else {
                maxLen = Math.max(maxLen, r - l);
                x = k;
                while(s.charAt(l) == s.charAt(l + 1)) l++;
                l++;
                r = l + 1;
            }
        }
        maxLen = Math.max(maxLen, r - l);
        return maxLen;
    }
}
