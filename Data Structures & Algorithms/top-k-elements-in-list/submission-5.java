class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) map.merge(num, 1, Integer::sum);    

        List<Integer>[] freq = new List[nums.length+1];

        map.forEach((key, value) -> {
            if(freq[value] == null) freq[value] = new ArrayList<Integer>();
            
            freq[value].add(key);
        });

        int j = 0;

        int[] res = new int[k];

        for(int i = nums.length; i > 0; i--) {
            if(freq[i] == null) continue;

            for(Integer num : freq[i]) {
                res[j++] = num;
                
                if(j == k) return res;
            }
        }

        return res;
    }
}
