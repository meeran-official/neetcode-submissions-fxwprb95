/*

    0   1   2   3   4   5   6   7   8   9   10  11
    A   B   A   A   B   B   B   B   B   A   A   B   B
        L
                                                        R
    
    windowSize - highFreqChar <= k

    L: 0
    R: 0
    
    - while R is in bound:
        - find the frequency of a character with maximum frequency
        - find the replacable characters
        - if replacable character <= K
            - update maximum window length
            - more R forward, expanding the window
        - if replacable character > K
            - move L forward, shrinking the window

    

    window length: R - L + 1

    maximum frequency:
    - store character frequency in map
    - find max: map.get(char) vs self

    replacable characters: window length - highest frequency of a character

    maximum window length: R - L + 1 vs self

    A   A   B   A   B   B   A
        L
                    R
    
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int N = s.length();
        int maxFreq = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        int maxWindLen = 0;

        for(int r = 0; r < N; r++) {
            charFreq.merge(s.charAt(r), 1, Integer::sum);
            maxFreq = Math.max(maxFreq, charFreq.get(s.charAt(r)));
            while(r - l + 1 - maxFreq > k) {
                charFreq.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }
            maxWindLen = Math.max(maxWindLen, r - l + 1);
        }

        return maxWindLen;
    }   
}






























