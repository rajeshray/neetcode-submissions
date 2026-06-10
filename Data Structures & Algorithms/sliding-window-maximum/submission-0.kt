class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val numMap = mutableMapOf<Int, Int>()
        val result = IntArray(nums.size - k + 1)
        var i = 0

        for (j in nums.indices) {
            numMap[nums[j]] = numMap.getOrDefault(nums[j], 0) + 1
            if (j - i + 1 == k) {
                result[i] = numMap.entries.filter { it.value > 0}.maxOfOrNull { it.key } ?: 0
                numMap[nums[i]] = numMap.getOrDefault(nums[i], 0) - 1
                i++
            }
        }

        return result
    }
}
