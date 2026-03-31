class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        List<Integer>[] freq = new List[nums.length + 1];

        map.forEach((key, v) -> {
            if(freq[v] == null) {
                freq[v] = new ArrayList<>();
            }

            freq[v].add(key);
        });

        int[] res = new int[k];
        int j = 0;

        for(int i = nums.length; i > 0; i--) {
            if(freq[i] == null) continue;

            for(int n : freq[i]) {
                res[j++] = n;

                if(j == k) break;
            }

            if(j == k) break;
        }

        return res;
    }
}

/*

freq : int[nums.length + 1]

LOOP num : nums
    map.merge(num, 1, Integer::sum)

map.forEach((k, v) -> {
    freq[v].add(k)
})

*/
