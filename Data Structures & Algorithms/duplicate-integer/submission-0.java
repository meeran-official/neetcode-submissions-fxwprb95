class Solution {
    public boolean hasDuplicate(int[] nums) {
        var unique = new HashSet<Integer>();

        for(int num : nums) {
            if(!unique.add(num)) {
                return true;
            }
        }

        return false;
    }
}