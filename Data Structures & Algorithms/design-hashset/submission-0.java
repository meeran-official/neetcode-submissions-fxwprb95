class MyHashSet {
    List set;
    public MyHashSet() {
        set = new ArrayList<Integer>();
    }
    
    public void add(int key) {
        if(contains(key)) return;
        set.add(key);
    }
    
    public void remove(int key) {
        if(!contains(key)) return;

        set.remove(set.indexOf(key));
    }
    
    public boolean contains(int key) {
        return set.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */