class Solution {
    public void sortColors(int[] nums) {
        if(nums.length <= 1) return;
        int l = 0, r = nums.length - 1, i = l;
        while(i <= r) {
            if(nums[i] == 0) {
                swap(nums, l, i);
                l++;
            } else if(nums[i] == 2) {
                swap(nums, r, i);
                r--;
                i--;
            }
            i++;
        }
    }

    private void swap(int[] nums, int j, int i) {
        if(nums[i] == nums[j]) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}