class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var map = getFreq(nums);

        int n = 10000;
        List<Integer>[] buckets = new List[n];
        int[] output = new int[k];

        map.forEach((key, value) -> {
            if(buckets[value] == null) {
                buckets[value] = new ArrayList<Integer>();
            }
            buckets[value].add(key);
        });

        int j = 0;

        for(int i = n-1; i > 0; i--) { // loop 10K times
            if(buckets[i] == null) continue;

            List<Integer> bucket = buckets[i];

            for(Integer num : bucket) {
                output[j++] = num;
                
                if(j == k) break;
            }
            if(j == k) break;
        }

        return output;
    }

    private HashMap<Integer, Integer> getFreq(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        return map;
    }
}
