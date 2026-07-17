class MedianFinder {
    private List<Integer> list;
    
    public MedianFinder() {
        list = new ArrayList<>();    
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        double res;
        if(list.size() % 2 != 0) {
            res = list.get(list.size() / 2);
        } else {
            int mid1 = (int) Math.ceil((list.size() + 1) / 2.0);
            int mid2 = (int) Math.floor((list.size() + 1) / 2.0);
            res = (list.get(mid1 - 1) + list.get(mid2 - 1)) / 2.0;
            System.out.println("size: " + list.size() + ", mid1: " + mid1 + ", mid2: " + mid2);
        }
        return res;
    }
}
