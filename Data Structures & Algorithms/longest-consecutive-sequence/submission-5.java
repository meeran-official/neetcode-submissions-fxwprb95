class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int res = 1;
        int longCons = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i-1] == 0) continue;
            
            if(nums[i] - nums[i-1] == 1) {
                res += 1;
            } else {
                if(res > longCons) {
                    longCons = res;
                }
                res = 1;
            }
        }

        if(res > longCons) {
            longCons = res;
        }
        
        return longCons;
    }
}

/*

0 2 3 20 21 22 23

2 3 4 4 5 10 20

1 -> 
20 -> 

*/
