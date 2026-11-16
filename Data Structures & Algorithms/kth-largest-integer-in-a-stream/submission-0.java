class KthLargest {
    private int idx;
    private int[] nums;
    public KthLargest(int k, int[] nums) {
        idx = nums.length - k;
        this.nums = nums;
    }
    
    public int add(int val) {
        int[] nums2 = nums;
        nums = new int[nums.length + 1];
        nums[nums.length - 1] = val;
        copy(nums, nums2);
        idx++;
        return nums[idx];
    }

    private void copy(int[] nums, int[] nums2) {
        for(int i = 0; i < nums2.length; i++) {
            nums[i] = nums2[i];
        }
    }
}
