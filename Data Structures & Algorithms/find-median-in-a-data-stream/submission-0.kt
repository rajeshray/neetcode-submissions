class MedianFinder {

    val minHeap = PriorityQueue<Int>()
    val maxHeap = PriorityQueue<Int>( compareByDescending {it} )

    fun addNum(num: Int) {

        maxHeap.add(num)
        minHeap.add(maxHeap.poll())

        if (minHeap.size > maxHeap.size) {
            maxHeap.add(minHeap.poll())
        }

    }


    fun findMedian(): Double {


        if (maxHeap.size == minHeap.size && maxHeap.size != 0) {
            return ((maxHeap.peek() + minHeap.peek()).toDouble())/2.0
        }

        if (maxHeap.size > minHeap.size) {
            return maxHeap.peek().toDouble()
        }

        return minHeap.peek().toDouble()

    }
}
