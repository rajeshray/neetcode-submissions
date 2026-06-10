class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = IntArray(nums.size - k + 1)
        val adq = ArrayDeque<Int>()
        var i = 0

        for (j in nums.indices) {
           while(adq.isNotEmpty() && nums[adq.last()] <= nums[j]) {
            adq.removeLast()
           }

           adq.addLast(j)

           if (adq.first() < i) adq.removeFirst()


            if (j - i + 1 == k) {
                result[i] = nums[adq.first()]
                i++
            }
        }

        return result
    }
}
