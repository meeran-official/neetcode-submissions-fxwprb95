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
        // if(nums.length == 0) return 0;
        // if(nums.length == 1) {
        //     if(nums[0] == val) return 0;
        //     else return 1;
        // }
        int i = 0;
        int j = nums.length - 1;
        System.out.println("ONE - i: " + i + ", j: " + j);
        while(i <= j) {
            while(i <= j && nums[i] != val) {
                i++;
            }
            while(i <= j && nums[j] == val) {
                j--;
            }
            System.out.println("TWO - i: " + i + ", j: " + j);
            if(i >= j) break;
            nums[i] = nums[j];
            i++;
            j--;
        }
        return j + 1;
    }
}