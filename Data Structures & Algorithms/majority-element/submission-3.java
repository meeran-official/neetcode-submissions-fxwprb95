class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int[] res = new int[1];
        map.forEach((k, v) -> {
            if(v > nums.length / 2) {
                res[0] = k;
            }
        });
        return res[0];
    }
}