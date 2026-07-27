class Solution {
    public int majorityElement(int[] nums) {
        int vote = 0, res = 0;
        for(int num : nums) {
            if(vote == 0) {
                res = num;
                vote++;
            } else {
                if (num == res) {
                    vote++;
                } else {
                    vote--;
                }
            }
        }
        return res;
    }
}