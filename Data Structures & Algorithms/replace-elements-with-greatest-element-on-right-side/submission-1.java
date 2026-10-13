class Solution {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        int rightMax = -1;
        for(int i = arr.length - 1; i >= 0; i--) {
            ans[i] = rightMax;
            rightMax = Math.max(arr[i], rightMax);
        }
        return ans;
    }
}