class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int i = 0;
        int r = nums.length - 1;

        while(i <= r) {
            if(nums[i] == 0) {
                swap(l, i, nums);
                l++;
            } else if(nums[i] == 2) {
                swap(r, i, nums);
                r--;
                i--;
            }
            i++;
        }
    }

    private void swap(int i, int j, int[] nums) {
        if(nums[i] == nums[j]) return;
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}