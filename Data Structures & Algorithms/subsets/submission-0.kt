class Solution {
    val finalList = mutableListOf<List<Int>>()
    fun subsets(nums: IntArray): List<List<Int>> {
        val current = mutableListOf<Int>()
        backtrack(0, nums, current)
        return finalList

    }

    fun backtrack(index: Int, nums: IntArray, current: MutableList<Int>) {
        if (index == nums.size) {
            finalList.add(current.toList())
            return
        }

        // add 

        current.add(nums[index])
        backtrack(index + 1, nums, current)

        // remove

        current.removeAt(current.size - 1)
        backtrack(index + 1, nums, current)
    }
}
