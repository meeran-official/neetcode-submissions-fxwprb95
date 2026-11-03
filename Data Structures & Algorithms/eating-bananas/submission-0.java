class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = getMax(piles);
        for(int i = 1; i <= max; i++) {
            int tot = 0;
            for(int pile : piles) {
                tot+= (int) Math.ceil((double) pile / i);
            }
            if(tot <= h) {
                return i;
            }
        }
        return -1;
    }
    private int getMax(int[] piles) {
        int max = 0;
        for(int pile : piles) {
            max = Math.max(max, pile);
        }
        //use stream
        return max;
    }
}
