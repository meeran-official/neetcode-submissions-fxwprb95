class Solution {
    /*

        1   1   2   8
        1   2   4   6
        48  24  6   1

        pref[i] = pref[i-1] * nums[i-1];

        
    */
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] pref = new int[N];
        int[] suff = new int[N];
        int[] res = new int[N];

        pref[0] = suff[N-1] = 1;
        for(int i = 1; i < N; i++) {
            pref[i] = pref[i-1] * nums[i-1];
            suff[N - i - 1] = suff[N - i] * nums[N - i];
        }
        for(int i = 0; i < N; i++) {
            res[i] = pref[i] * suff[i];
        }
        return res;
    }
}  
