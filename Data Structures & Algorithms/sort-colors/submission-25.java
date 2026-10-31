class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, i = l;
        while(i <= r) {
            if(nums[i] == 0) {
                swap(nums, l, i);
                l++;
                if(i < l) i = l;
            } 
            if(nums[i] == 2) {
                swap(nums, r, i);
                r--;
            } 
            if(nums[i] == 1) {
                i++;
            }
        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}