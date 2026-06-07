class Solution {
    fun singleNumber(nums: IntArray): Int {
        var num = 0
        for (i in nums) {
            num = num xor i
        }
        return num
    }
}
