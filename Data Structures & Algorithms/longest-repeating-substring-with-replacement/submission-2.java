/*
0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16
A   A   B   B   B   A   A   B   B   B   A   A   A   B   A   B
                            m                   r   


-1  0   1   2   3   4   5   6   7   8   9   10  11  12
    A   B   A   A   B   B   B   B   B   A   B   B
    l
    r

len: 12
A: 4
B: 8


# k = 4 
# max =

- Place m pointer on the next unique character. r = m + 1. l = m - 1;
    - If r < N and K > 0 and m == r, r++
    - If r < N and K > 0 and m != r, r++, K--
    - If l >= 0 and K > 0 and m == l, l--
    - If l >= 0 and K > 0 and m != l, l--, K--
    - If K = 0 OR (l < 0 AND r == N), calculate the max length. Reset K

-1  0   1   2   3   4   5   6   7   8   9   10  11  12
    A   B   A   A   B   B   B   B   B   A   B   B
        m
            r
    l

    A   A   A   B   A   B   B
    m
                        r
l
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int m = 0;
        int maxLen = 0;
        int r = 0;
        int l = 0;

        while(m < N) {
            r = m + 1;
            l = m - 1;
            int x = k;
            while(r < N && (x > 0 || s.charAt(r) == s.charAt(m))) {
                if(s.charAt(r) != s.charAt(m)) {
                    x--;
                }
                r++;
            }
            while(l >= 0 && (x > 0 || (s.charAt(l) == s.charAt(m)))) {
                if(s.charAt(l) != s.charAt(m)) {
                    x--;
                }
                l--;
            }
            maxLen = Math.max(maxLen, r - (l + 1));
            while(m < N-1 && s.charAt(m) == s.charAt(m + 1)) m++;
            m++;
        }
        maxLen = Math.max(maxLen, r - (l + 1));
        return maxLen;
    }
}






























