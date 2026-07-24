class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();

        for(int num : nums) {
            index.merge(num, 1, (oldVal, newVal) -> Integer.sum(oldVal, newVal));
        }

        for(int i = 0; i < nums.length; i++) {
            if(index.containsKey(target - nums[i])) {
                return new int[]{i, index.get(target - nums[i])};
            }
        }
        return new int[]{-1, -1};
    }
}
