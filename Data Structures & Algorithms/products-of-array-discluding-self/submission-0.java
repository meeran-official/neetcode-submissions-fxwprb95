class Solution {
    /*
        1   2   4   6

        1   1   2   8 - P        

        48  24  6   1  - S

        -----------

        -1  0   1   2   3
        
        1   -1  0   0   0

        0   6   6   3   1


        ------

        2   3   4

        1   2   6   -P

        12   4   1

        12  8   6


        
    */
    public int[] productExceptSelf(int[] nums) {
        
        int prefixProd = 1;
        int[] prefix = new int[nums.length];
        
        prefix[0] = prefixProd;

        for(int i = 0; i < nums.length - 1; i++) {
            prefixProd *= nums[i];
            
            prefix[i+1] = prefixProd;
        }

        int suffixProd = 1;
        int[] suffix = new int[nums.length];

        suffix[nums.length-1] = suffixProd;

        for(int i = nums.length-1; i > 0; i--) {
            suffixProd *= nums[i];
            
            suffix[i-1] = suffixProd;
        }

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }    
}  
