class Solution {
    /*
        1   2   8   48  -   s
        1   2   4   6       -   x
        48  48  24  6  -   p

        res[] = s[i-1] * p[i+1]


    */
    public int[] productExceptSelf(int[] nums) {
        int[] suf = new int[nums.length];
        int[] pre = new int[nums.length];
        int sufPrd = 1;
        int prePrd = 1;
        for(int i = 0; i < nums.length; i++) {
            sufPrd *= nums[i];
            suf[i] = sufPrd;
            prePrd *= nums[nums.length - 1 - i];
            pre[nums.length - 1 - i] = prePrd;
        }
        int[] res = new int[nums.length];
        res[0] = pre[1];
        res[nums.length - 1] = suf[nums.length - 2];
        for(int i = 1; i < nums.length - 1; i++) {
            res[i] = suf[i - 1] * pre[i + 1];
        }
        return res;
    }
}  
