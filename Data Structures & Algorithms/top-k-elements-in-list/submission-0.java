class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var map = getFreq(nums);

        var list = new ArrayList<Integer>();

        map.forEach((key, value) -> {
            if(value >= k) {
                list.add(key);
            }
        });

        return list.stream()
            .mapToInt(i -> i)
            .toArray();
    }

    private HashMap<Integer, Integer> getFreq(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        return map;
    }
}
