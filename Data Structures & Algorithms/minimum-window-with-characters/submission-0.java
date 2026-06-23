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

    Exit early if:
    - S Lentgth is < T length
    - T is empty

    tCharFreq: populate char frequencies of T, Map<Character, Integer>
    auxCharFreq: Map<Character, Integer>
    L, R, start, end: 0
    minWindowLength: s.len()

    While R is in bound, Increment R
        If R in tCharFreq
            If auxCharFreq(R) == tCharFreq(R)
                clear auxCharFreq
                Set L = R
            Increment auxCharFreq(R)
        While auxCharFreq == tCharFreq:
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
            if(tCharFreq.containsKey(s.charAt(r))) {
                if(auxCharFreq.getOrDefault(r, 0).equals(tCharFreq.get(r))) {
                    auxCharFreq.clear();
                    l = r;
                }
                auxCharFreq.merge(r, 1, Integer::sum);
            }
            while(auxCharFreq.equals(tCharFreq)) {
                if(tCharFreq.containsKey(l)) {
                    if((r - l + 1) < minWindLen) {
                        minWindLen = r - l + 1;
                        start = l;
                        end = r + 1;
                    }
                    auxCharFreq.merge(l, -1, Integer::sum);
                }
                l++;
            }
        }
        return s.subString(start, end);
    }
}





























