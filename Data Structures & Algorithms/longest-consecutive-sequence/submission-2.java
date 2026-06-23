class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for(int num : nums) {
            set.add(num);
        }

        for(int s : set) {
            if(set.contains(s-1)) {
                res++;
            }
        }

        if(res > 0) res += 1;

        return res;
    }
}
