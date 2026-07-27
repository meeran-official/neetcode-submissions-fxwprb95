class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            while(nums[l] != val) {
                l++;
            }
            while(nums[r] == val) {
                r--;
            }
            if(l >= r) break;
            int bkp = nums[l];
            nums[l] = nums[r];
            nums[r] = bkp; 
        }
        System.out.println(Arrays.toString(nums));
        return l;
    }
}