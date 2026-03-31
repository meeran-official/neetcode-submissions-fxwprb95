class Solution {
    public int majorityElement(int[] nums) {
        int max = nums.length/2;
        var map = new HashMap<Integer, Integer>();
        for(int num: nums) {
            map.merge(num, 1, Integer::sum);

            if(map.get(num) > max) return num;
        }

        return -1;
    }
}