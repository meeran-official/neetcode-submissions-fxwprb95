/*
    Initialize i as 0 and j as length of nums - 1
    Loop nums
    i will be tracking from left and only stop at val, that to be removed
    j will be tracking from right and only stop at non-val, that is to be kept
    When the above two condition met, replace val of i with val of j
    If i and j cross each other break
    return i + 1
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            while(i <= j && nums[i] != val) {
                i++;
            }
            while(i <= j && nums[j] == val) {
                j--;
            }
            if(i >= j) break;
            nums[i] = nums[j];
            i++;
            j--;
        }
        return i;
    }
}