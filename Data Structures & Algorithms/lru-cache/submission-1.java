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
        int val = map.getOrDefault(key, -1);
        if(val == -1) return -1;
        Queue<Integer> tempQ = new LinkedList<>();
        while(!keysQ.isEmpty()) {
            int poll = keysQ.poll();
            if(poll == key) continue;
            tempQ.offer(poll);
        }
        tempQ.offer(key);
        keysQ = tempQ;
        return val;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
        keysQ.offer(key);
        if(keysQ.size() > capacity) {
            map.remove(keysQ.poll());
        }
    }
}
