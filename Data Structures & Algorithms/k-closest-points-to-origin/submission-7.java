class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<int[], Integer> map = new HashMap<>();        
        for(int[] point : points) {
            map.put(point, calc(point));
        }
        PriorityQueue<Map.Entry<int[], Integer>> maxQ = 
            new PriorityQueue<>((x, y) -> Integer.compare(y.getValue(), x.getValue()));
        for(Map.Entry<int[], Integer> entry : map.entrySet()) {
            maxQ.offer(entry);
            if(maxQ.size() > k) {
                maxQ.poll();
            }
        }
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = maxQ.poll().getKey();
        }
        return res;
    }
    private int calc(int[] point) {
        return (int) Math.pow(point[0], 2) + (int) Math.pow(point[1], 2);
    }
}
