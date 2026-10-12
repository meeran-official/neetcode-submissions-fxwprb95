class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int max = 1;
        for(int num : nums) {
            if(set.contains(num - 1)) continue;
            int count = 1;
            while(set.contains(num + count)) {
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
