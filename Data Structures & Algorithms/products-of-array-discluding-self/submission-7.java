class Solution {
    /*
        Output: [48,24,12,8]

        1   2   4   6

        1   1   2   8

    */
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];

        int prefProd = 1;
        res[0] = 1;
        for(int i = 1; i < N; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        for(int i = N - 1; i >= 0; i--) {
            res[i] *= prefProd;
            prefProd *= nums[i];
        }
        return res;
    }
}  
