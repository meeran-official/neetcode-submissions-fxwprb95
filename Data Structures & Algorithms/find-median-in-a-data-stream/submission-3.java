class MedianFinder {
    Queue<Integer> small;
    Queue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        large = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }
    
    public void addNum(int num) {
        small.offer(num);

        if(small.size() - large.size() > 1
            || (!large.isEmpty() && large.peek() < small.peek())) {
            large.offer(small.poll());
        }

        if(large.size() - small.size() > 1) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if(Integer.compare(small.size(), large.size()) == 0) {
            return (small.peek() + large.peek()) / 2.0;
        }
        if(Integer.compare(small.size(), large.size()) > 0) {
            return small.peek();
        }
        return large.peek();
    }
}
