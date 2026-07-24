class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }

        System.out.println(index.toString());

        for(int i = 0; i < nums.length; i++) {
            if(index.containsKey(target - nums[i])) {
                if(index.get(target - nums[i]) == i) continue;
                return new int[]{i, index.get(target - nums[i])};
            }
        }
        return new int[]{-1, -1};
    }
}
