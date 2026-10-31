class Solution {
    public void sortColors(int[] nums) {
        if(nums.length <= 1) return;
        int l = 0, r = nums.length - 1, i = l;
        while(i <= r) {
            if(i != l && nums[i] == 0) {
                swap(nums, l, i);
                l++;
            } else if(nums[i] == 2) {
                swap(nums, r, i);
                r--;
            } else {
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