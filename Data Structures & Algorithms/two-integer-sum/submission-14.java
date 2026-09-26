/*
    Return early if nums length is less than 2
    Value of nums and its respective index to be stored as key value pair in map.
    Iterate nums
        If target - num key is present in map, 
            return index of both
    return empty
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                if(map.get(target - nums[i]) == i) continue;
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return new int[] {0};
    }
}
