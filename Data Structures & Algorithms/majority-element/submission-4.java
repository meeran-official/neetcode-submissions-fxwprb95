class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, max = 0;
        for(int num : nums) {
            map.merge(num, 1, Integer::sum);
            if(map.get(num) > max) {
                max = map.get(num);
                res = num;
            }
        }
        return res;
    }
}