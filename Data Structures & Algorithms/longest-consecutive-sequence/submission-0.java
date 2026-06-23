class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;

        for(int num : nums) {
            set.add(num);
        }

        for(int num : nums) {
            if(set.contains(num-1)) {
                res += 1;
            }
        }

        return res;
    }
}
