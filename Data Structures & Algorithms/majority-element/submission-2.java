class Solution {
    public int majorityElement(int[] nums) {
        int cand = -1;
        int vote = 0;

        for(int num : nums) {
            if(vote == 0) {
                cand = num;
            }

            vote += (cand == num)? 1: -1;
        }

        return cand;
    }
}