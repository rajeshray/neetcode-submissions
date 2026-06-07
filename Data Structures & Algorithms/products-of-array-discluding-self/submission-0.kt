class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val numSize = nums.size
        val suffixProd = IntArray(numSize) 
        val prefixProd = IntArray(numSize)
        val finalProd = IntArray(numSize)
        prefixProd[0] = nums[0]
        suffixProd[numSize-1] = nums[numSize-1]
        for (i in 1..numSize-1) {
            prefixProd[i]= prefixProd[i-1] * nums[i]
        }
        for(i in numSize-2 downTo 0) {
            suffixProd[i]= suffixProd[i+1] * nums[i]
        }

        for (i in 0..numSize-1) {
            if (i == 0) {
                finalProd[0] = suffixProd[i+1]
            } else if (i == numSize-1) {
                finalProd[numSize-1] = prefixProd[i-1]
            } else {
                finalProd[i] = prefixProd[i-1] * suffixProd[i+1]
            }
        }

        return finalProd

    }
}
