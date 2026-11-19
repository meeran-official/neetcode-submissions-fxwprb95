class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxQ = new PriorityQueue<>(
            (a, b) -> Integer.compare(calc(b), calc(a)));
        for(int[] point : points) {
            maxQ.offer(point);
            if(maxQ.size() > k) maxQ.poll();
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(!maxQ.isEmpty()) {            
            res[i++] = maxQ.poll();
        }
        return res;
    }
    private int calc(int[] point) {
        return (int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2);
    }
}
