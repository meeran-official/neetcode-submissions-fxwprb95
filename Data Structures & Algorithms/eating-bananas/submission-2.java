class Solution {
    int minRate = 0;
    public int minEatingSpeed(int[] piles, int h) {
        int maxRate = getMax(piles);
        bSearch(1, maxRate, piles, h);
        return minRate;
    }
    private void bSearch(int low, int high, int[] piles, int maxHour) {
        if(low > high) return;
        int mid = high + (low - high) / 2;
        if(isWithinMaxHour(mid, piles, maxHour)) {
            minRate = mid;
            bSearch(low, mid - 1, piles, maxHour);
        } else {
            bSearch(mid + 1, high, piles, maxHour);
        }
    }
    private boolean isWithinMaxHour(int rate, int[] piles, int maxHour) {
        int totalHours = 0;
        for(int pile : piles) {
            totalHours += (int) Math.ceil((double) pile / rate);
        }
        return totalHours <= maxHour;
        //Use Stream
    }
    private int getMax(int[] piles) {
        return Arrays.stream(piles).max().getAsInt();
    }
}
