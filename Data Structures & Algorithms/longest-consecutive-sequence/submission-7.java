class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        Set<Integer> firstSeq = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }
        
        set.forEach(k -> {
            if(!set.contains(k-1)) {
                firstSeq.add(k);
            }
        });

        int curr;
        int len;
        int longest = 0;

        for(Integer s : firstSeq) {
            curr = s;
            len = 1;
            while(set.contains(++curr)) {
                len++;
            }

            longest = Math.max(len, longest);
        }

        return longest;
    }
}

/*

1 2 3 20 21 22 23 30 31

23 2 31 20 1 21 30 3 22

1 -> 2 3
20 -> 23 21 22
30 -> 31

*/
