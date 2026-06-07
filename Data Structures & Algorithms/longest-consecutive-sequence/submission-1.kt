class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val setNums = nums.toHashSet()

        var maxLen = 0

        for (num in setNums) {
            if (!setNums.contains(num-1)) {
                var tempLen = 1
                var tempNum = num
                while(setNums.contains(tempNum+1)) {
                    tempNum++
                    tempLen++
                }

                maxLen = max(maxLen, tempLen)

            }
        } 
        return maxLen

    }
}
