class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = fetchPrefix(nums);
        int[] post = fetchPostfix(nums);
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int prod = 1;
            if(i - 1 >= 0) {
                prod *= pref[i - 1];
            }
            if(i + 1 < nums.length) {
                prod *= post[i + 1];
            }
            res[i] = prod;  
        }
        return res;
    }

    private int[] fetchPrefix(int[] nums) {
        int[] pref = new int[nums.length];
        int runProd = 1;
        for(int i = 0; i < nums.length; i++) {
            runProd *= nums[i];
            pref[i] = runProd;
        }
        return pref;
    }

    private int[] fetchPostfix(int[] nums) {
        int[] post = new int[nums.length];
        int runProd = 1;
        for(int i = nums.length - 1; i > 0; i--) {
            runProd *= nums[i];
            post[i] = runProd;
        }
        return post;
    }
}  
