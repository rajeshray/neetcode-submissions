class Solution {

    val finalList = mutableListOf<List<Int>>()
    fun permute(nums: IntArray): List<List<Int>> {
        backtrack(nums, mutableListOf(), mutableSetOf())
        return finalList
    }

    fun backtrack(nums: IntArray, current: MutableList<Int>, visited: MutableSet<Int>) {
        if (current.size == nums.size) {
            finalList.add(current.toList())
            return
        }


        for (i in 0 until nums.size) {
            if (visited.contains(nums[i])) continue
            current.add(nums[i])
            visited.add(nums[i])
            backtrack(nums, current, visited)
            val removeVal = current[current.size - 1]
            current.remove(removeVal)
            visited.remove(removeVal)
        }
    }
}
