class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int>()

        for (num in nums) {
            maxHeap.add(num)
            if (maxHeap.size > k) {
                maxHeap.poll()
            }
         }

         return maxHeap.poll()
    }
}
