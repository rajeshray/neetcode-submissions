class KthLargest(k: Int, nums: IntArray) {
    val heap = PriorityQueue<Int>()
    val kSize: Int
    init {
        kSize = k
        for(num in nums) add(num)
    }
    
    fun add(`val`: Int): Int {
        heap.add(`val`)
        if (heap.size > kSize) {
            heap.poll()
        } 
        return heap.peek()
    }
}
