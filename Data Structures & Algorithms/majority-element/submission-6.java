/*
    Initialize vote as 0, nominee as first nums val
    Loop nums, as num
        if vote is 0
            nominee = num
            vote++
        else If num is nominee
            vote++
        else
            vote--
    return nominee

*/

class Solution {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int nominee = -1;
        for(int num : nums) {
            if(vote == 0) {
                nominee = num;
                vote++;
            } else if (num == nominee) {
                vote++;
            } else {
                vote--;
            }
        }
        return nominee;
    }
}