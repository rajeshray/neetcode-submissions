class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val map = mutableMapOf<Int, Unit>()
        for (num in nums) {
            if (map.contains(num)) return true
            else map[num] = Unit

        }

        return false

    }
}
