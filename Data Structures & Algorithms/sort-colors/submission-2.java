class Solution {
    public void sortColors(int[] nums) {
        if(nums.length < 3) return;

        int left = 0;
        int mid = left;
        int right = nums.length-1;
        
        while(true) {
            while(nums[left] == 0) {
                left++;
            }
            
            if(mid < left) {
                mid = left;
            }

            while(nums[mid] == 1) {
                mid++;
            }

            while(nums[right] == 2) {
                right--;
            }

            if(mid >= right) break;

            if(nums[mid] == 0) {
                swap(mid, left, nums);
            } else {
                swap(mid, right, nums);
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