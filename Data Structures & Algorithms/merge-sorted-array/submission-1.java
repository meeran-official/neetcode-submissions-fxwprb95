class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = Arrays.copyOf(nums1, m);
        int k = 0;
        int i = 0;
        int j = 0;
        while(k < m + n) {
            if(j >= n || (i < m && temp[i] <= nums2[j])) {
                nums1[k++] = temp[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
    }
}