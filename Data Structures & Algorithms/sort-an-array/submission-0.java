class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(0, nums.length-1, nums);

        return nums;
    }

    private void mergeSort(int l, int r, int[] nums) {

        if(l == r) return;

        int m = (r + l) / 2;

        mergeSort(l, m, nums);
        mergeSort(m+1, r, nums);
        merge(l, m, r, nums);
    }

    private void merge(int l, int m, int r, int[] nums) {

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