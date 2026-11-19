class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxQ = new PriorityQueue<>(Comparator.comparingInt(a -> -a[0]));
        for(int[] point : points) {
            maxQ.offer(new int[] {calc(point), point[0], point[1]});
            if(maxQ.size() > k) {
                maxQ.poll();
            }
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[] x = maxQ.poll();
            res[i] = new int[] {x[1], x[2]};
        }
        return res;
    }
    private int calc(int[] point) {
        return (int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2);
    }
}
