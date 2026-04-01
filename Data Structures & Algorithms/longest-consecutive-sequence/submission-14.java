/*
    12  10   1   2   11   16   15    

    1   2   
    10  11 12
    15  16

    set(nums)
    init(nums.init, if !set(num-1))
    count(nums.init, inc++)
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        List<Integer> init = new ArrayList<>();

        for(int num : nums) {
            set.add(num);
        }

        int res = 1;
        for(int num : set) {
            // if(set.contains(num-1)) continue;
            int cur = num;
            int count = 1;
            while(set.contains(++cur)) count++;
            res = Math.max(res, count);
        }
        return res;
    }
}
