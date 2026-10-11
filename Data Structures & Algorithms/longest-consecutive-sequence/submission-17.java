class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 1) return 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, 0);
        }
        int max = 0;
        for(int num : nums) {
            if(map.containsKey(num - 1)) continue;
            if(!map.containsKey(num + 1)) continue;
            int count = 1;
            while(map.containsKey(num + count)) {
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
