/* 
    
    T: XYZZ

    O   U   Z   O   D   Y   X   A   Z   V   Z   Y   X   Z
                                            L
                                                            R

    O   U   Z   O   D   Y   Y   X   A   Z   V   Z   Y   X   Z
                                                                R
                                                L   

    O   U   Z   O   D   Y   Q   Z   Y   Y   X   X   X   Z   Z   A   Z   Y   X
                                                                            R
                                                                    L

    A   A   Y   Q   Z   Y   Y   X 
                        L
                                R

    x   y   z  z
        L
                    R  

    t="ABC"

    A   D   O   B   E   C   O   D   E   B   A   N   C
                                                    R
                                        L

    ABCC

    X   A   B   B   C   C
    
    t="abcdd"

    x   a   a   a   b   b   b   b   b   c   d   d
                                                R
                L

    Exit early if:
    - S Lentgth is < T length
    - T is empty

    countT: populate char frequencies of T, Map<Character, Integer>
    window: Map<Character, Integer>
    L, R, start, end: 0
    minWindowLength: s.len()

    While R is in bound of S size, Increment R
        If R NOT IN countT SKIP

        // If window(R) == countT(R)
        //     clear window
        //     Set L = R
        Increment window(R)

        While hasEnough(window, countT) and L is in bound of S size:
            If L in countT
                If window length is < minWindowLength
                    minWindowLength = window length
                    start = L
                    end = R 
                Decrement window(L)
            Move L forward

    Return s[start:end]
*/
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        if(t.isBlank()) return "";

        int[] countT = new int[128];
        int[] window = new int[128];
        
        int l = 0;
        int res[] = {-1, -1};
        int minLen = Integer.MAX_VALUE;
        int have = 0;
        int need = 0;
        
        for(int i = 0; i < t.length(); i++) {
            countT[t.charAt(i)]++;
            if(countT[t.charAt(i)] == 1) {
                need++;
            }
        }

        for(int r = 0; r < s.length(); r++) {
            if(countT[s.charAt(r)] == 0) continue;
            
            window[s.charAt(r)]++;

            if(window[s.charAt(r)] == countT[s.charAt(r)]) {
                have++;
            }
            
            while(have == need) {
                if(countT[s.charAt(l)] > 0) {
                    if((r - l + 1) <= minLen) {
                        minLen = r - l + 1;
                        res[0] = l;
                        res[1] = r;
                    }
                    window[s.charAt(l)]--;

                    if(window[s.charAt(l)] < countT[s.charAt(l)]) {
                        have--;
                    }
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}





























