class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }

    private void divide(int[] nums, int l, int r) {
        if(l == r) {
            return;
        }
        int m = (l + r) / 2;
        divide(nums, l, m);
        divide(nums, m + 1, r);
        conquer(nums, l, m, r);
    }

    private void conquer(int[] nums, int l, int m, int r) {
        List<Integer> temp = new ArrayList<>();
        int i = l, j = m + 1;
        while(i <= m && j <= r) {
            if(nums[i] < nums[j]) {
                temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
            }
        }
        while(i <= m) {
            temp.add(nums[i]);
            i++;
        }
        while(j <= r) {
            temp.add(nums[j]);
            j++;
        }
        for(i = l; i <= r; i++) {
            nums[i] = temp.get(i - l);
        }
    }
}