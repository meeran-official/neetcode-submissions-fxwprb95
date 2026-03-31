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
        
        int[] suffix = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] res = new int[nums.length];
        
        prefix[0] = 1;
        suffix[nums.length-1] = 1;

        for(int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i-1] * prefix[i-1] ;
        }
        
        for(int i = nums.length-2; i >= 0; i--) {
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        for(int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }    
}  
