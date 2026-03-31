class Solution {
    public void sortColors(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if(l == r) return;

        int m = (l + r) / 2;

        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        int len1 = m + 1 - l;
        int len2 = r - m;

        int[] left = new int[len1];
        int[] right = new int[len2];

        for(int i = 0; i < len1; i++) {
            left[i] = nums[l + i];
        }

        for(int i = 0; i < len2; i++) {
            right[i] = nums[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i < len1 && j < len2) {
            if(left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < len1) {
            nums[k] = left[i];
            i++;
            k++;
        }

        while(j < len2) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }
}