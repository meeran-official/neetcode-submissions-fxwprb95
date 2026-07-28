class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        freq.forEach((key, v) -> {
            heap.offer(new int[]{v, key});
            if(heap.size() > k) {
                heap.poll();
            }
        });
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }
}
