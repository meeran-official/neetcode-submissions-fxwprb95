class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }
        List<int[]> list = new ArrayList<>();
        freq.forEach((key, v) -> {
            list.add(new int[]{v, key});
        });
        list.sort((a, b) -> b[0] - a[0]);
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = list.get(i)[1];
        }
        return res;
    }
}
