/*
    -4  -1  -1  0   1   2
    i   j

    -1  0   1   2   -1  -4


    4   5   -2  -2  -1  -4

    (4,-2,-2)   (-4, 5, -1)   (-4, 6, -2)

    -4  -3  -2  -2  -1  0   4   5   6

    -4  -3  -2  6  -1  0   4   5   -2

    -4 = -4
                               

    (-4, 6, -2) (-4, 5, -1) (-4, 4, 0)  (-4, 0, 4)  (-4 -1 5)   (-4 -2 6)   (-4 -2 6) ()

    -4  -7  -9  -11 -12 -12 -8  -3  3

    -4 + 5  = 1
    
    
    -4  -6  -8  -9  -5  0

    nums[i] = - (nums[j] + nums[k])
    -nums[i] = nums[j] + nums[k]

    nums[i] + nums[j] + nums[k] = 0
    
    nums[i] + nums[j] + (-(nums[i] + nums[j])) = 0
    
    nums[i] + nums[j] = -nums[k]
    
    -(nums[i] + nums[j]) = nums[k]

    nums[i] + nums[j] = -nums[k]

    -4 = -(1 + 3)

    5   = - (-1 - 4)

    -4  -3  -2  -2  -1  0   4   5   6

    -4, 0, 4
    -4, 4, 0

    num[i] = -(nums[j] + nums[k])

    -4  -3  -2  -2  -1  0   4   5   6
    i   j                           k

    -4 = -(-4)



*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < N - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = N - 1;
            while(j < k) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if(k < N - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if(nums[j] + nums[k] < -nums[i]) {
                    j++;
                    continue;
                }
                if(nums[j] + nums[k] > -nums[i]) {
                    k--;
                    continue;
                }
                
                res.add(List.of(nums[i], nums[j], nums[k]));
                j++;
            }
        }
        return res;
    }
}



























