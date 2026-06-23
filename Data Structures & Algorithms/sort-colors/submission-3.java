class Solution {
    public void sortColors(int[] nums) {
        if(nums.length < 3) return;

        int l = 0;
        int m = l + 1;
        int r = nums.length-1;
        
        while(true) {
            while(nums[l] == 0) {
                l++;
            }
            
            if(m < l) {
                m = l + 1;
            }

            while(nums[m] == 1) {
                m++;
            }

            while(nums[r] == 2) {
                r--;
            }

            if(m > r) break;
            if(m == r && nums[m] == 2) break;

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

/*
- 2 2 1 1 0 0
- 0 2 1 1 0 2
- 0 0 1 1 2 2

2 2 1 1 0 1

1 2 1 1 0 0






0 0 0 2 1 2 0 0 2 0 1 2 2 2

0 1 1 1 1 2 0 0 2 0 1 2 2 1

2 0 0 2 1 2 0 0 2 0 1 2 2 0
*/