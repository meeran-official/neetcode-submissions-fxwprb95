class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0;
        int k = nums.length - 1;
        while(i <= j && j <= k) {
            while(i < nums.length && nums[i] == 0) i++;
            j = j < i ? i : j;
            while(k > 0 && nums[k] == 2) k--;
            while(j < nums.length && nums[j] == 1) j++;
            if(!(i <= j && j <= k)) break;
            if(nums[j] == 0) {
                swap(nums, j, i);
                i++;
            } else {
                swap(nums, j, k);
                k--;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}