/*
0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16
A   A   B   B   B   A   A   B   B   B   A   A   A   B   A   B
                            m                   r   


    0   1   2   3   4   5   6   7   8   9   10  11
    A   B   A   A   B   B   B   B   B   A   B   B
    i   j
    
   
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

    A   B   A   A   B   B   B   B   B   A   B   B
    L
                                                R

    count: 1

    0   1   2   3   4   5   6
    A   A   A   B   A   B   B
                    l
                        r

*/

class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> charSet = new HashSet<>();

        int N = s.length();
        for(int i = 0; i < N; i++) {
            charSet.add(s.charAt(i));
        }

        int maxLen = 0;

        for(char c : charSet) {
            int charFreq = 0;
            int l = 0;
            for(int r = 0; r < N; r++) {
                if(s.charAt(r) == c) {
                    charFreq++;
                }
                while(r - l + 1 - charFreq > k) {
                    if(s.charAt(l) == c) {
                        charFreq--;
                    }
                    l++;
                }
                System.out.println("window: " + (r - l + 1));
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }
        return maxLen;
    }
}






























