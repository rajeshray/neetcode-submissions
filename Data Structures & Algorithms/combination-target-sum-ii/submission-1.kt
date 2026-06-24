class Solution {
    val finalList = mutableListOf<List<Int>>()
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        backtrack(0, candidates, mutableListOf(), target)
        return finalList
    }


    fun backtrack(start: Int, nums: IntArray, current: MutableList<Int>, remainingSum: Int) {

        if (remainingSum == 0) {
            finalList.add(current.toList())
            return
        }

        if (remainingSum < 0) {
            return
        }


        for (i in start until nums.size) {
            if (i > start && nums[i] == nums[i-1]) continue
            current.add(nums[i])
            backtrack(i+1, nums, current, remainingSum - nums[i])
            current.removeAt(current.size - 1)
        }

    }
}
