/*
    lowerHeight = Math.min(nums[l], nums[r])
    lowerHeight * gapLen()
    maxWater
*/
class Solution {
    public int maxArea(int[] heights) {
        int N = heights.length;
        int l = 0;
        int r = N - 1;
        int maxCap = 0;

        while(l < r) {
            int low = Math.min(heights[l], heights[r]);
            int cap = low * (r - l);
            maxCap = Math.max(maxCap, cap);

            if(heights[l] < heights[r]) l++;
            else r--;
        }
        return maxCap;
    }
}
