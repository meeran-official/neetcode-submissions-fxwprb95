class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - n - 1;
        int j = nums2.length - 1;
        int k = nums1.length - 1;
        System.out.println("nums1, i, j, k -> " + Arrays.toString(nums1) + ", " + i + ", " + j + ", " + k);
        while(k >= 0 && j >= 0) {
            if(i >= 0 && nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
            System.out.println("nums1, i, j, k -> " + Arrays.toString(nums1) + ", " + i + ", " + j + ", " + k);
        }
    }
}