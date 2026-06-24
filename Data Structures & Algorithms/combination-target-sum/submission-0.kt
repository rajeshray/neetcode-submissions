class Solution {
    val finalList = mutableListOf<List<Int>>()
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val current = mutableListOf<Int>()
        backtrack(0, nums, current, target)
        return finalList
    }

    fun backtrack(start: Int, nums: IntArray, current: MutableList<Int>, remainingSum: Int) {

       if (remainingSum == 0) {
          finalList.add(current.toList())
       }

       if (remainingSum < 0) {
        return
       }


       for (i in start until nums.size) {
          current.add(nums[i])
          backtrack(i,nums,current, remainingSum - nums[i])
          current.removeAt(current.size - 1)
       }

    }
}
