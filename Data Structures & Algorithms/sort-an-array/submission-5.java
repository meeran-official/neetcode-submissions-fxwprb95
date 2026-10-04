class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums);        
        return nums;
    }

    private void mergeSort(int[] nums) {
        divide(nums, 0, nums.length - 1);
    }

    private void divide(int[] nums, int l, int r) {
        if(l == r) return;
        int m = (l + r) / 2;
        divide(nums, l, m);
        divide(nums, m + 1, r);
        conquer(nums, l, m, r);
    }

    private void conquer(int[] nums, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        List<Integer> sorted = new ArrayList<>();
        while(i <= m && j <= r) {
            if(nums[i] < nums[j]) {
                sorted.add(nums[i++]);
            } else {
                sorted.add(nums[j++]);
            }
        }
        while(i <= m) {
            sorted.add(nums[i++]);
        }
        while(j <= r) {
            sorted.add(nums[j++]);
        }
        for(int k = l; k <= r; k++) {
            nums[k] = sorted.get(k - l);
        }
    }
}