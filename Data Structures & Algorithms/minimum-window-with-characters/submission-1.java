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

    Exit early if:
    - S Lentgth is < T length
    - T is empty

    tCharFreq: populate char frequencies of T, Map<Character, Integer>
    auxCharFreq: Map<Character, Integer>
    L, R, start, end: 0
    minWindowLength: s.len()

    While R is in bound of S size, Increment R
        If R NOT IN tCharFreq SKIP

        If auxCharFreq(R) == tCharFreq(R)
            clear auxCharFreq
            Set L = R
        Increment auxCharFreq(R)

        While auxCharFreq == tCharFreq and L is in bound of S size:
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

        Map<Character, Integer> tCharFreq = new HashMap<>(); // try with array for optimization
        Map<Character, Integer> auxCharFreq = new HashMap<>();
        int l = 0;
        int start = 0;
        int end = 0;
        int minWindLen = s.length();
        
        for(int i = 0; i < t.length(); i++) {
            tCharFreq.merge(t.charAt(i), 1, Integer::sum);
        }

        for(int r = 0; r < s.length(); r++) {
            if(!tCharFreq.containsKey(s.charAt(r))) continue;

            if(auxCharFreq.getOrDefault(s.charAt(r), 0).equals(tCharFreq.get(s.charAt(r)))) {
                auxCharFreq.clear();
                l = r;
            }
            auxCharFreq.merge(s.charAt(r), 1, Integer::sum);
            System.out.println("auxCharFreq: " + auxCharFreq);
            
            while(auxCharFreq.equals(tCharFreq) && l < s.length()) {
                if(tCharFreq.containsKey(s.charAt(l))) {
                    if((r - l + 1) <= minWindLen) {
                        minWindLen = r - l + 1;
                        start = l;
                        end = r + 1;
                        System.out.println("minWindLen: " + minWindLen);
                    }
                    auxCharFreq.merge(s.charAt(l), -1, Integer::sum);
                }
                l++;
            }
        }
        System.out.println("start: " + start + ", end: " + end);
        return s.substring(start, end);
    }
}





























