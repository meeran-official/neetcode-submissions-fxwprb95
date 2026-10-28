class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<int[], Double> map = new HashMap<>();
        for(int i = 0; i < points.length; i++) {
            map.put(points[i], calc(points[i]));
        }
        PriorityQueue<Map.Entry<int[], Double>> heap = new PriorityQueue<>(Comparator.comparing(Map.Entry<int[], Double>::getValue).reversed());
        for(Map.Entry<int[], Double> entry : map.entrySet()) {
            heap.offer(entry);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        // while (!heap.isEmpty()) {
        //     Map.Entry<int[], Double> entry = heap.poll();
        //     System.out.println(Arrays.toString(entry.getKey()) + ": " + entry.getValue());
        // }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = heap.poll().getKey();
        }

        return res;
    }

    private double calc(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
}
