/*
    Initialize i and j as 0
    Loop nums
    i will be tracking from left and only stop at val, that to be removed
    j will be tracking from right and only stop at non-val, that is to be kept
    When the above two condition met, replace val of i with val of j
    If i and j cross each other break
    return i + 1
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while(true) {
            if(nums[i] != val) {
                i++;
            }
            if(nums[j] == val) {
                j--;
            }
            if(!(i < nums.length && j > 0 && i <= j)) break;
            if(nums[i] != val || nums[j] == val) continue;

            System.out.println("output: " + Arrays.toString(nums));
            System.out.println("i: " + i + ", j: " + j);
            nums[i] = nums[j];
            i++;
            j--;
        }
        System.out.println("final output: " + Arrays.toString(nums));
        System.out.println("final i: " + i + ", j: " + j);
        return i;
    }
}