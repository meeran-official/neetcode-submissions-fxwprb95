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
            maxCap = Math.max(maxCap, Math.min(heights[l], heights[r]) * (r - l));

            if(heights[l] < heights[r]) l++;
            else r--;
        }
        return maxCap;
    }
}
