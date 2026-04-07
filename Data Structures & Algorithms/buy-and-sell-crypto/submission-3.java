/*
    10  2   5   6   3   7   2   1   3   1
*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int maxProfit = 0;
        int l = 0;
        int N = prices.length;
        for(int r = 1; r < N; r++) {
            if(prices[r] < prices[l]) {
                l = r;
                continue;
            } 
            maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
        }
        return maxProfit;
    }
}
