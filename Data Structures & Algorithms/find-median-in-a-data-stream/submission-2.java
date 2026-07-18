class MedianFinder {
    private List<Integer> list;
    
    public MedianFinder() {
        list = new ArrayList<>();    
    }
    
    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }
    
    public double findMedian() {
        double res;
        if((list.size() & 1) == 1) {
            return list.get(list.size() / 2);
        }
        return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;  
    }
}
