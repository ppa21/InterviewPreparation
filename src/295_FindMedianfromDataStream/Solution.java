/*
        * ArrayList:
            * Time Complexity:
                * addNum:
                    * add ---> O(1)
                    * remove ---> O(n)
                * findMedian ---> O(n)
            * Space Complexity ---> O(n)

        * PriorityQueue: MORE EFFICIENT
            * Time Complexity:
                * addNum:
                    * add ---> O(logn)
                    * remove ---> O(logn)
                * findMedian ---> O(1)
            * Space Complexity ---> O(n)
 */
class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);       // Descending order ---> [6, 5, 4]
        large = new PriorityQueue<>();                      // Ascending order ---> [1, 2, 3]
    }

    public void addNum(int num) {
        small.add(num);

        if(large.size() > 0 && small.peek() > large.peek()) {
            int val = small.poll();
            large.add(val);
        }

        /*
                * SIZE of small and large MUST BE approximately the SAME
                    * DIFFERENCE of 1 is OK
                    * Anything GREATER than 1 ---> >= 2
                        * MOVE small.peek to large
                            * large.add(small.poll())
         */
        if(small.size() - large.size() >= 2) {
            int val = small.poll();
            large.add(val);
            return;
        }

        // SAME explanation as ABOVE
        if(large.size() - small.size() >= 2) {
            int val = large.poll();
            small.add(val);
        }
    }

    public double findMedian() {
        if(small.size() > large.size()) {
            return small.peek();
        }

        if(large.size() > small.size()) {
            return large.peek();
        }

        return (large.peek() + small.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */