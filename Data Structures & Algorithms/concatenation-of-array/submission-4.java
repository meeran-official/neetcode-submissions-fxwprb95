/*
    Return early if nums is empty
    Create a new array 'ans', twice the length of 'nums'
    Loop index 'i' from 0 to length of 'ans'
    Populate ans[i] and ans[i + len(nums)] with nums[i]
    return
*/
class Solution {
    public int[] getConcatenation(int[] nums) {
        if(nums.length == 0) return new int[]{};
        int[] ans = new int[nums.length * 2];
        for(int i = 0; i < nums.length; i++) {
            ans[i] = ans[i + nums.length] = nums[i];
        }
        return ans;
    }
}