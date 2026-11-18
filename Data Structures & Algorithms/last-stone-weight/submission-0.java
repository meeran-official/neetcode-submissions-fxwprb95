class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHp = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for(int stone : stones) {
            maxHp.offer(stone);
        }
        while(maxHp.size() > 1) {
            int x = maxHp.poll();
            int y = maxHp.poll();
            maxHp.offer(Math.abs(x - y));    
        }
        return maxHp.peek();
    }
}
