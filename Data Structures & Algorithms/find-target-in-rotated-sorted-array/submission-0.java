/*
3   4   5   X   X   9   0   1   2   X
        t
                    m

l = 0
r = nums.length - 1

1   2   3   4   5   6
        t
    m

pivotIdx = getPivotIndex(nums, l, r)
pivot = nums[pivotIdx]

IF target in (pivot, r):
    return findTargetIdx(nums, target, pivotIdx, r)
else:
    return findTargetIdx(nums, target, l, pivotIdx - 1)

findTargetIdx(nums, t, l, r):
    LOOP l < r:
        m = l + (r - l)/2
        if(nums[t] > nums[m]):
            l = m + 1
        else:
            r = m

    if nums[l] == target:
        return l
    return -1

getPivotIndex(nums, l, r):
    LOOP l < r:
        m = l + (r - l)/2
        if(nums[m] > nums[l]):
            l = m + 1
        else:
            r = m
    return l

*/

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        int pivotIdx = getPivotIndex(nums, l, r);
        int pivot = nums[pivotIdx];

        if(target >= pivot && target <= nums[r]) {
            return getTargetIndex(nums, target, pivotIdx, r);
        } else {
            return getTargetIndex(nums, target, l, pivotIdx - 1);
        }
    }

    private int getTargetIndex(int[] nums, int target, int l, int r) {
        while(l < r) {
            int m = l + (r - l) / 2;
            if(target > nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l] == target? l : -1;
    }

    private int getPivotIndex(int[] nums, int l, int r) {
        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        System.out.println("Pivot Idx: " + l);
        return l;
    }
}




















