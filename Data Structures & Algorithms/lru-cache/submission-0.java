class LRUCache {
    int capacity;
    Map<Integer, Integer> map;
    Queue<Integer> keysQ;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        keysQ = new LinkedList<>();
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
        keysQ.offer(key);
        if(keysQ.size() > capacity) {
            map.remove(keysQ.poll());
        }
    }
}
