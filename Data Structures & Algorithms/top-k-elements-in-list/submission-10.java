class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }
        Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.offer(entry);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }
        return res;
    }
}
