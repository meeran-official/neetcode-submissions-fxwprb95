class Solution {
    public int search(int[] nums, int target) {
        return bst(nums, 0, nums.length, target);
    }

    private int bst(int[] nums, int l, int r, int target) {
        if(l > r) return -1;
        int m = l + (r - l) / 2;
        if(target < nums[m]) {
            return bst(nums, l, m - 1, target);
        } else if(target > nums[m]) {
            return bst(nums, m + 1, r, target);
        } else {
            return m;
        }
    }
}
