class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            val diff = target - nums[i]
            if (map.contains(diff)) {
                return intArrayOf(map[diff]!!, i)
            } else {
                map[nums[i]] = i
            }
        }
        return intArrayOf()
    }
}
