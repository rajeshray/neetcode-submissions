class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val finalProd = IntArray(nums.size)
        finalProd[0]=1
        for (i in 1..nums.size-1) {
            finalProd[i] = finalProd[i-1] * nums[i-1]
        }
        var suffixProd = nums[nums.size-1]
        for (i in nums.size-2 downTo 0) {
            finalProd[i] *= suffixProd
            suffixProd*= nums[i]
        }
         return finalProd

    }
}
