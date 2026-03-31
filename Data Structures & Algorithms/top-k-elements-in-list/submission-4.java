class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();

        for(int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        map.forEach((key, value) -> {
            heap.offer(new int[] {value, key});

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
