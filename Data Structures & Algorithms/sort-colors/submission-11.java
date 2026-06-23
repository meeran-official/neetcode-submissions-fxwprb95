class Solution {
    public void sortColors(int[] nums) {
        if(nums.length < 3) return;

        int l = 0;
        int m = l;
        int r = nums.length-1;
        
        while(true) {
            while(l < nums.length-1 && nums[l] == 0) {
                l++;
            }
            
            if(m < l) {
                m = l;
            }

            while(m < nums.length-1 && nums[m] == 1) {
                m++;
            }

            while(r > 0 && nums[r] == 2) {
                r--;                
            }

            if(m > r || r == 0 || l == nums.length-1 || || m == nums.length-1) break;

            if(nums[m] == 0) {
                swap(m, l, nums);
            } else {
                swap(m, r, nums);
            }
        }
    }

    private void swap(int x, int y, int[] nums) {
        int aux = nums[x];
        nums[x] = nums[y];
        nums[y] = aux;
    }
}
