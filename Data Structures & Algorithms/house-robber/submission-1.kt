class Solution {
    fun rob(nums: IntArray): Int {
        var prev2 = 0
        var prev1 = 0
        var result = 0
        for(num in nums) {
            result = max(prev1,prev2 + num)
            prev2 = prev1
            prev1 = result
        }

        return result

    }
}
