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
            if (visited.contains(i)) continue
            current.add(nums[i])
            visited.add(i)
            backtrack(nums, current, visited)
            current.removeAt(current.size - 1)
            visited.remove(i)
        }
    }
}
