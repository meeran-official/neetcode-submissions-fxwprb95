class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int num : nums) {
            if(map.containsKey(target - num)) {
                return new int[]{map.get(num), map.get(target - num)};
            }
        }

        return new int[]{-1, -1};
    }
}
