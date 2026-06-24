class Solution {
    fun rob(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        for(i in nums.indices) {
            if (i == 0) {
                dp[i] = nums[0]
            } else if (i == 1) {
                dp[i] = max(nums[0],nums[1])
            } else dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        }

        return dp[nums.size - 1]

    }
}
