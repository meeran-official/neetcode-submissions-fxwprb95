class KthLargest {
    int k;
    private PriorityQueue<Integer> maxHp = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            maxHp.offer(num);
        }
    }
    
    public int add(int val) {
        maxHp.offer(val);
        List<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= k; i++) {
            temp.add(maxHp.poll());
        }
        int res = temp.get(temp.size() - 1);
        for(int t : temp) {
            maxHp.offer(t);
        }
        return res;
    }
}
