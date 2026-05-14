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

    tCharFreq: populate char frequencies of T, Map<Character, Integer>
    auxCharFreq: Map<Character, Integer>
    L, R, start, end: 0
    minWindowLength: s.len()

    While R is in bound of S size, Increment R
        If R NOT IN tCharFreq SKIP

        // If auxCharFreq(R) == tCharFreq(R)
        //     clear auxCharFreq
        //     Set L = R
        Increment auxCharFreq(R)

        While hasEnough(auxCharFreq, tCharFreq) and L is in bound of S size:
            If L in tCharFreq
                If window length is < minWindowLength
                    minWindowLength = window length
                    start = L
                    end = R 
                Decrement auxCharFreq(L)
            Move L forward

    Return s[start:end]
*/
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        if(t.isBlank()) return "";

        int[] tCharFreq = new int[128];
        int[] auxCharFreq = new int[128];
        
        int l = 0;
        int start = 0;
        int end = 0;
        int minWindLen = s.length();
        
        for(int i = 0; i < t.length(); i++) {
            tCharFreq[t.charAt(i)]++;
        }

        for(int r = 0; r < s.length(); r++) {
            if(tCharFreq[s.charAt(r)] == 0) continue;
            
            auxCharFreq[s.charAt(r)]++;
            
            while(hasEnough(tCharFreq, auxCharFreq)) {
                if(tCharFreq[s.charAt(l)] > 0) {
                    if((r - l + 1) <= minWindLen) {
                        minWindLen = r - l + 1;
                        start = l;
                        end = r + 1;
                        System.out.println("minWindLen: " + minWindLen);
                    }
                    auxCharFreq[s.charAt(l)]--;
                }
                l++;
            }
        }
        return s.substring(start, end);
    }

    private boolean hasEnough(int[] tCharFreq, int[] auxCharFreq) {
        for(int i = 0; i < 128; i++) {
            if(auxCharFreq[i] < tCharFreq[i]) return false;
        }
        return true;
    }
}





























