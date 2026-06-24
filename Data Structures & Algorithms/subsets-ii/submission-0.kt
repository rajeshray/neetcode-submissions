class Solution {
    val finalList = mutableListOf<List<Int>>()
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        backtrack(0,nums, mutableListOf())
        return finalList
    }


    fun backtrack(index: Int, nums: IntArray, current: MutableList<Int>) {
        if (index == nums.size) {
            finalList.add(current.toList())
            return
        }

        current.add(nums[index])
        backtrack(index + 1, nums, current)
        current.removeAt(current.size - 1)

         var next = index + 1
         while (next < nums.size && nums[next] == nums[index]) next++

         backtrack(next, nums, current)
    }
}
