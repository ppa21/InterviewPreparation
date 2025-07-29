/*
        * time complexity  = O(1)
        * space complexity = O(k); k = windowSize
*/
class MovingAverage {
    private Queue<Integer> queue;
    private int windowSum = 0;
    private int windowSize;
    
    public MovingAverage(int windowSize) {
        this.windowSize = windowSize;
        this.queue = new LinkedList<>();
    }
    
    public double next(int val) {
        windowSum += val;
        queue.offer(val);
        
        if (queue.size() > windowSize) {
            int excludedNum = queue.poll();
            windowSum -= excludedNum;
        }
        
        return (double) windowSum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
