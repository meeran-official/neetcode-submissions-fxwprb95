class KthLargest {
    int k;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            minHeap.offer(num);      
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        minHeap.poll();
        // List<Integer> temp = new ArrayList<>();
        // for(int i = 1; i <= k; i++) {
        //     temp.add(minHeap.poll());
        // }
        // int res = temp.get(temp.size() - 1);
        // for(int t : temp) {
        //     minHeap.offer(t);
        // }
        return minHeap.peek();
    }
}
