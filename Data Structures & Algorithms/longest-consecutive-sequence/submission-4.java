class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        int res = 1;

        for(int num : nums) {
            set.add(num);
        }

        for(int s : set) {
            if(set.contains(s-1)) {
                res++;
            }
        }

        return res;
    }
}
