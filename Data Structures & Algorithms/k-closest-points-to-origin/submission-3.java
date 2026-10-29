class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for(int i = 0; i < points.length; i++) {
            int dist = calc(points[i]);
            minHeap.offer(new int[] {dist, points[i][0], points[i][1]});
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] polled = minHeap.poll();
            res[i] = new int[] {polled[1], polled[2]};
        }
        return res;
    }

    private int calc(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
