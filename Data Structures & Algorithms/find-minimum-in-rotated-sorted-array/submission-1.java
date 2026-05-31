/*
    2   3   4   5   6   1   2
                        r
                    m
                        l    

    
    1   2   3   4   5   6
    r
    m
    l                
    
    6   1   2   3   4   5
        r
    m
        l    

    3   4   5   6   1   2
                r
                m
                    l     


    0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18
    6   7   8   9   10  11  12  13  14  15  16  17  18  19  1   2   3   4   5
                                                                            R
                                        M
    L    

    

    4   5   0   1   2   3
                        R
            M
    L    


    3   4   5   6   7       

    4   5   6   7   3
                    R
                M
                    L


    1   2   3   4   5   6
                        R
                M
    L

    3   4   5   6   1   2
                        R
                    M
                L

    6   1   2   3   4   5
        R
    M
        L

    4   5   1   2   3
            R
        M
            L
    
    L = 0
    R = len(nums) - 1

    LOOP l < r:
        m = l + (r - l)/2
        if(nums[m] < nums[r]):
            r = m
        else:
            l = m + 1




    Loop (L < R)
        If R < L
            L = (R + L) / 2
        else
            R = (R + L) / 2
    return L
   
*/

class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
























