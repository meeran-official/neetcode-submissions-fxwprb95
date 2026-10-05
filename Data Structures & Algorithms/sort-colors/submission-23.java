class Solution {
    public void sortColors(int[] nums) {
        int l = 0, i = 0, r = nums.length - 1;
        while(i <= r) {
            if(nums[i] == 0) {
                swap(nums, i, l);
                l++;
            } else if(nums[i] == 2) {
                swap(nums, i, r);
                r--;
                i--;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        if(i == j) {
            System.out.println("Same indeex");
            return;
        }
        if(nums[i] == nums[j]) {
            System.out.println("Same value");
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}