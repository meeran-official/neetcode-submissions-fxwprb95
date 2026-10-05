class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = i;
        int k = nums.length - 1;
        while(i <= j && j <= k) {
            System.out.println("ONE - i: " + i + ", j: " + j + ", k: " + k);
            while(nums[i] == 0) i++;
            while(nums[k] == 2) k--;
            while(nums[j] == 1) j++;
            System.out.println("TWO - i: " + i + ", j: " + j + ", k: " + k);
            if(!(i <= j && j <= k)) break;
            if(nums[j] == 0) {
                swap(nums, j, i);
            } else {
                swap(nums, j, k);
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}