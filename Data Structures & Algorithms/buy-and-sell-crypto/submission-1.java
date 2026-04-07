class Solution {
    public int maxProfit(int[] prices) {
        int bought = prices[0];
        int sold = 0;
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] <= bought) {
                bought = prices[i];
                sold = 0;
                continue;
            }
            if(prices[i] < sold) {
                continue;
            }
            sold = prices[i];
            int profit = sold - bought;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}
